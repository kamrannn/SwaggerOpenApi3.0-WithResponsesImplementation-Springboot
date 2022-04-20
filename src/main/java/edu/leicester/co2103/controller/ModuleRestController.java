package edu.leicester.co2103.controller;

import edu.leicester.co2103.domain.Module;
import edu.leicester.co2103.domain.Session;
import edu.leicester.co2103.repo.ModuleRepository;
import edu.leicester.co2103.repo.SessionRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modules")
public class ModuleRestController {

    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    SessionRepository sessionRepository;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched the list of modules",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Module.class))
                    }),
            @ApiResponse(responseCode = "404", description = "List is empty",
                    content = {
                            @Content
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @GetMapping
    public ResponseEntity<Object> list() {
        try {
            List<Module> moduleList = moduleRepository.findAll();
            if (moduleList.isEmpty()) {
                return new ResponseEntity<>("Module List is empty", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(moduleList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created the module",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Module.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Module module) {
        try {
            return new ResponseEntity<>(moduleRepository.save(module), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the module",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Module.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Not found the module against this ID",
                    content = {
                            @Content
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Module updatedModule) {
        try {
            Optional<Module> module = moduleRepository.findById(updatedModule.getCode());
            if (module.isPresent()) {
                module.get().setCode(updatedModule.getCode());
                module.get().setLevel(updatedModule.getLevel());
                module.get().setOptional(updatedModule.isOptional());
                module.get().setSessions(updatedModule.getSessions());
                return new ResponseEntity<>(moduleRepository.save(module.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("There is no module against this ID", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public String delete(@RequestParam(name = "code") String code) {
        try {
            Optional<Module> module = moduleRepository.findById(code);
            if (module.isPresent()) {
                sessionRepository.deleteAll(module.get().getSessions());
                module.get().getSessions().clear();
                moduleRepository.delete(module.get());
                return "Module is successfully deleted from the database";
            } else {
                throw new RuntimeException("There is no convenor against this Id");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{code}/sessions")
    public List<Session> modulesTaughtByConvenor(@PathVariable(name = "code") String code) {
        try {
            Optional<Module> module = moduleRepository.findById(code);
            if (module.isPresent()) {
                return module.get().getSessions();
            } else {
                throw new RuntimeException("There is no module against this Id");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/{code}/sessions")
    public List<Session> createSessionInModule(@PathVariable(name = "code") String code, @RequestBody Session session) {
        try {
            Optional<Module> module = moduleRepository.findById(code);
            if (module.isPresent()) {
                module.get().getSessions().add(session);
                moduleRepository.save(module.get());
                return module.get().getSessions();
            } else {
                throw new RuntimeException("There is no module against this Id");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{code}/sessions/{id}")
    public Session getSessionFromAModule(@PathVariable(name = "code") String code, @PathVariable(name = "id") long sessionId) {
        try {
            Optional<Module> module = moduleRepository.findById(code);
            if (module.isPresent()) {
                if (module.get().getSessions().isEmpty()) {
                    throw new RuntimeException("There are no sessions in this module");
                } else {
                    for (Session session : module.get().getSessions()
                    ) {
                        if (session.getId() == sessionId) {
                            return session;
                        } else {
                            throw new RuntimeException("There is no session with this ID in this module");
                        }
                    }
                }
                return null;
            } else {
                throw new RuntimeException("There is no module against this Id");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{code}/sessions")
    public List<Session> updateSessionInModule(@PathVariable(name = "code") String code, @RequestBody Session session) {
        try {
            Optional<Module> module = moduleRepository.findById(code);
            if (module.isPresent()) {
                for (Session existingSession : module.get().getSessions()
                ) {
                    if (existingSession.getId() == session.getId()) {
                        existingSession.setDatetime(session.getDatetime());
                        existingSession.setDuration(session.getDuration());
                        existingSession.setTopic(session.getTopic());
                        sessionRepository.save(existingSession);
                    }
                }
                return module.get().getSessions();
            } else {
                throw new RuntimeException("There is no module against this Id");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{code}/sessions/{id}")
    public String deleteSessionFromAModule(@PathVariable(name = "code") String code, @PathVariable(name = "id") long sessionId) {
        try {
            Optional<Module> module = moduleRepository.findById(code);
            if (module.isPresent()) {
                if (module.get().getSessions().isEmpty()) {
                    throw new RuntimeException("There are no sessions in this module");
                } else {
                    for (Session session : module.get().getSessions()
                    ) {
                        if (session.getId() == sessionId) {
                            module.get().getSessions().remove(session);
                            moduleRepository.saveAndFlush(module.get());
                            return "Session is successfully deleted from the selected module";
                        } else {
                            throw new RuntimeException("There is no session with this ID in this module");
                        }
                    }
                }
                return "Session is successfully deleted from the selected module";
            } else {
                throw new RuntimeException("There is no module against this Id");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
