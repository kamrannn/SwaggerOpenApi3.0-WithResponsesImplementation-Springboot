package edu.leicester.co2103.controller;

import edu.leicester.co2103.domain.Convenor;
import edu.leicester.co2103.domain.Module;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/convenors")
public class ConvenorRestController {

    @Autowired
    ConvenorRepository convenorRepository;
    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    SessionRepository sessionRepository;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched the list of convenors",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Convenor.class))
                    }),
            @ApiResponse(responseCode = "404", description = "There is no convenor in the database",
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
            List<Convenor> convenorList = convenorRepository.findAll();
            if (convenorList.isEmpty()) {
                return new ResponseEntity<>("There is no convenor in the database", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(convenorList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created the Convenor",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Convenor.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Convenor convenor) {
        try {
            return new ResponseEntity<>(convenorRepository.save(convenor), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the convenor",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Convenor.class))
                    }),
            @ApiResponse(responseCode = "404", description = "There is no convenor against this ID",
                    content = {
                            @Content
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Convenor updatedConvenor) {
        try {
            Optional<Convenor> convenor = convenorRepository.findById(updatedConvenor.getId());
            if (convenor.isPresent()) {
                convenor.get().setModules(updatedConvenor.getModules());
                convenor.get().setName(updatedConvenor.getName());
                convenor.get().setPosition(updatedConvenor.getPosition());
                return new ResponseEntity<>(convenorRepository.save(convenor.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("There is no convenor against this ID", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted the convenor from the database",
                    content = {
                            @Content
                    }),
            @ApiResponse(responseCode = "404", description = "There is no convenor against this ID",
                    content = {
                            @Content
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam(name = "id") long id) {
        try {
            Optional<Convenor> convenor = convenorRepository.findById(id);
            if (convenor.isPresent()) {
                convenor.get().getModules().clear();
                convenorRepository.delete(convenor.get());
                return new ResponseEntity<>("Convenor is successfully deleted from the database", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("There is no convenor against this Id", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched the list of modules Taught by Convenor",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Module.class))
                    }),
            @ApiResponse(responseCode = "404", description = "There is no convenor in the database",
                    content = {
                            @Content
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {
                            @Content
                    })
    })
    @GetMapping("/{id}/modules")
    public ResponseEntity<Object> modulesTaughtByConvenor(@PathVariable(name = "id") long id) {
        try {
            Optional<Convenor> convenor = convenorRepository.findById(id);
            if (convenor.isPresent()) {
                return new ResponseEntity<>(convenor.get().getModules(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("There is no convenor against this Id", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
