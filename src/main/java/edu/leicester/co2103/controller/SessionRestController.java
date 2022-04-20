package edu.leicester.co2103.controller;

import edu.leicester.co2103.domain.Convenor;
import edu.leicester.co2103.domain.Module;
import edu.leicester.co2103.domain.Session;
import edu.leicester.co2103.repo.ConvenorRepository;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessions")
public class SessionRestController {

    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    ConvenorRepository convenorRepository;
    @Autowired
    ModuleRepository moduleRepository;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All sessions are successfully deleted",
                    content = {
                            @Content
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @DeleteMapping
    public ResponseEntity<Object> deleteAllSessions() {
        try {
            sessionRepository.deleteAll();
            return new ResponseEntity<>("All sessions are successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched the list of sessions",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Session.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @GetMapping
    public ResponseEntity<Object> listAllSessions(@RequestParam(name = "convenor", required = false) Optional<Long> convenorId,
                                                  @RequestParam(name = "module", required = false) Optional<String> code) {
        if (convenorId.isPresent() && code.isEmpty()) {
            Optional<Convenor> convenor = convenorRepository.findById(convenorId.get());
            if (convenor.isPresent()) {
                HashMap<Long, Session> map = new HashMap<>();
                for (Module module : convenor.get().getModules()
                ) {
                    for (Session session : module.getSessions()
                    ) {
                        map.put(session.getId(), session);
                    }
                }
                List<Session> sessions = new ArrayList<>();
                map.forEach((key, value) -> sessions.add(value));
                return new ResponseEntity<>(sessions, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("There is no convenor against this ID", HttpStatus.NOT_FOUND);
            }
        } else if (convenorId.isEmpty() && code.isPresent()) {
            Optional<Module> module = moduleRepository.findById(code.get());
            if (module.isPresent()) {
                return new ResponseEntity<>(module.get().getSessions(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("There is no module against this ID", HttpStatus.NOT_FOUND);
            }
        } else if (convenorId.isPresent() && code.isPresent()) {
            Optional<Convenor> convenor = convenorRepository.findById(convenorId.get());
            if (convenor.isPresent()) {
                for (Module module : convenor.get().getModules()
                ) {
                    if (module.getCode().equalsIgnoreCase(code.get())) {
                        return new ResponseEntity<>(module.getSessions(), HttpStatus.OK);
                    }
                }
            } else {
                return new ResponseEntity<>("There is no convenor against this ID", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("You haven't entered wrong parameters", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
