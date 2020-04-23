package com.codenation.demo.logEvent.service;

import com.codenation.demo.logEvent.model.LogEvent;
import com.codenation.demo.logEvent.repository.LogEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogEventServiceImpl implements LogEventService {

    @Autowired
    LogEventRepository logEventRepository;

    @Override
    public LogEvent save( LogEvent logEvent) {
        return this.logEventRepository.save(logEvent);
    }

    @Override
    public Page<LogEvent> findAllPagingAndSorting( int page, int size, String sortByNameColumn ){
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "id");

        return logEventRepository.findAllPagingAndSorting(
                pageRequest
        );
    }

    @Override
    public Optional<LogEvent> findById(Long id) {

        return this.logEventRepository.findById(id);
    }

    @Override
    public Page<LogEvent> findByUserPagingAndSorting(String user, int page, int size, String sortByNameColumn) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.DESC, "user");

        return logEventRepository.findByUserPagingAndSorting(
                user,
                pageRequest
        );
    }

    @Override
    public Page<LogEvent> findByLevelPagingAndSorting(String level, int page, int size, String sortByNameColumn) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(sortByNameColumn));

        return logEventRepository.findByLevelPagingAndSorting(
                level,
                pageRequest
        );
    }

    @Override
    public Page<LogEvent> findByDescriptionPagingAndSorting(String description, int page, int size, String sortByNameColumn) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(sortByNameColumn));

        return logEventRepository.findByDescriptionPagingAndSorting(
                description,
                pageRequest
        );
    }

    @Override
    public Page<LogEvent> findByDescriptionContainPagingAndSorting(String description, int page, int size, String sortByNameColumn) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(sortByNameColumn));

        return logEventRepository.findByDescriptionContainPagingAndSorting(
                description,
                pageRequest
        );
    }

    @Override
    public Page<LogEvent> findByLogPagingAndSorting(String log, int page, int size, String sortByNameColumn) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(sortByNameColumn));

        return logEventRepository.findByLogPagingAndSorting(
                log,
                pageRequest
        );
    }

    @Override
    public Page<LogEvent> findByLogContainPagingAndSorting(String log, int page, int size, String sortByNameColumn) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(sortByNameColumn));

        return logEventRepository.findByLogContainPagingAndSorting(
                log,
                pageRequest
        );
    }

    @Override
    public Page<LogEvent> findByNumberPagingAndSorting(Long number, int page, int size, String sortByNameColumn) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(sortByNameColumn));

        return logEventRepository.findByNumberPagingAndSorting(
                number,
                pageRequest
        );
    }


}
