package com.codenation.demo.logEvent.controller;


import com.codenation.demo.controller.advice.ResourceNotFoundException;
import com.codenation.demo.logEvent.model.LogEvent;
import com.codenation.demo.logEvent.service.LogEventServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/logEvent")
public class LogEventController {
    @Autowired
    private LogEventServiceImpl logEventService;

    @PostMapping()
    @ApiOperation("Register new log event")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Event log successfully registered")})
    public ResponseEntity<LogEvent> create(@Valid @RequestBody LogEvent logEvent) {
        return new ResponseEntity<LogEvent>(
                this.logEventService
                        .save(logEvent),
                HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation("List all Log Event")
    public Page<LogEvent> findAllPagingAndSorting(
        @RequestParam(
            value = "page",
            required = false,
            defaultValue = "0") int page,
        @RequestParam(
            value = "size",
            required = false,
            defaultValue = "10") int size,
        @RequestParam(
            value = "sortByNameColumn",
            required = false,
            defaultValue = "id") String sortByNameColumn)
    {

        return this.logEventService
                .findAllPagingAndSorting(
                        page,
                        size,
                        sortByNameColumn
                );
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Log event not found"), @ApiResponse(code = 200, message = "Log event located")})
    public ResponseEntity<LogEvent> findById(@PathVariable("id") Long id) {

        return new ResponseEntity<LogEvent>(
                this.logEventService
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Log event")
                ),
                HttpStatus.OK);
    }

    @GetMapping("/byUser/{user}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Logs event not found"), @ApiResponse(code = 200, message = "Logs event located by user")})
    public Iterable<LogEvent> findByUserPagingAndSorting(
            @PathVariable("user") String user,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size,
            @RequestParam(
                    value = "sortByNameColumn",
                    required = false,
                    defaultValue = "id") String sortByNameColumn)
    {

        return this.logEventService
                .findByUserPagingAndSorting(
                        user,
                        page,
                        size,
                        sortByNameColumn
                );
    }

    @GetMapping("/byLevel/{level}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Logs event not found"), @ApiResponse(code = 200, message = "Logs event located by Level")})
    public Iterable<LogEvent> findByLevelPagingAndSorting(
            @PathVariable("level") String level,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size,
            @RequestParam(
                    value = "sortByNameColumn",
                    required = false,
                    defaultValue = "id") String sortByNameColumn)
    {

        return this.logEventService
                .findByLevelPagingAndSorting(
                        level,
                        page,
                        size,
                        sortByNameColumn
                );
    }

    @GetMapping("/byDescription/{description}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Logs event not found"), @ApiResponse(code = 200, message = "Logs event located by description")})
    public Iterable<LogEvent> findByDescriptionPagingAndSorting(
            @PathVariable("description") String description,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size,
            @RequestParam(
                    value = "sortByNameColumn",
                    required = false,
                    defaultValue = "id") String sortByNameColumn)
    {

        return this.logEventService
                .findByDescriptionPagingAndSorting(
                        description,
                        page,
                        size,
                        sortByNameColumn
                );
    }

    @GetMapping("/byDescriptionContain/{description}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Logs event not found"), @ApiResponse(code = 200, message = "Logs event located by description")})
    public Iterable<LogEvent> findByDescriptionContainPagingAndSorting(
            @PathVariable("description") String description,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size,
            @RequestParam(
                    value = "sortByNameColumn",
                    required = false,
                    defaultValue = "id") String sortByNameColumn)
    {

        return this.logEventService
                .findByDescriptionContainPagingAndSorting(
                        description,
                        page,
                        size,
                        sortByNameColumn
                );
    }

    @GetMapping("/byLog/{log}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Logs event not found"), @ApiResponse(code = 200, message = "Logs event located by log")})
    public Iterable<LogEvent> findByLogPagingAndSorting(
            @PathVariable("log") String log,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size,
            @RequestParam(
                    value = "sortByNameColumn",
                    required = false,
                    defaultValue = "id") String sortByNameColumn)
    {

        return this.logEventService
                .findByDescriptionPagingAndSorting(
                        log,
                        page,
                        size,
                        sortByNameColumn
                );
    }

    @GetMapping("/byLogContain/{log}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Logs event not found"), @ApiResponse(code = 200, message = "Logs event located by log")})
    public Iterable<LogEvent> findByLogContainPagingAndSorting(
            @PathVariable("log") String log,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size,
            @RequestParam(
                    value = "sortByNameColumn",
                    required = false,
                    defaultValue = "id") String sortByNameColumn)
    {

        return this.logEventService
                .findByLogContainPagingAndSorting(
                        log,
                        page,
                        size,
                        sortByNameColumn
                );
    }

    @GetMapping("/byNumber/{number}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Logs event not found"), @ApiResponse(code = 200, message = "Logs event located by number")})
    public Iterable<LogEvent> findByNumberPagingAndSorting(
            @PathVariable("number") Long number,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size,
            @RequestParam(
                    value = "sortByNameColumn",
                    required = false,
                    defaultValue = "id") String sortByNameColumn)
    {

        return this.logEventService
                .findByNumberPagingAndSorting(
                        number,
                        page,
                        size,
                        sortByNameColumn
                );
    }

}
