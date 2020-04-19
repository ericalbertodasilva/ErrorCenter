package com.codenation.demo.logEvent.service;

import com.codenation.demo.logEvent.model.LogEvent;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface LogEventService {

    LogEvent save(LogEvent logEvent);

    Page<LogEvent> findAllPagingAndSorting(int page, int size, String sortByNameColumn);

    Optional<LogEvent> findById(Long id);

    Page<LogEvent> findByUserPagingAndSorting(String user, int page, int size, String sortByNameColumn);

    Page<LogEvent> findByLevelPagingAndSorting(String level, int page, int size, String sortByNameColumn);

    Page<LogEvent> findByDescriptionPagingAndSorting(String description, int page, int size, String sortByNameColumn);

    Page<LogEvent> findByDescriptionContainPagingAndSorting(String description, int page, int size, String sortByNameColumn);

    Page<LogEvent> findByLogPagingAndSorting(String log, int page, int size, String sortByNameColumn);

    Page<LogEvent> findByLogContainPagingAndSorting(String log, int page, int size, String sortByNameColumn);

    Page<LogEvent> findByNumberPagingAndSorting(Long number, int page, int size, String sortByNameColumn);

}
