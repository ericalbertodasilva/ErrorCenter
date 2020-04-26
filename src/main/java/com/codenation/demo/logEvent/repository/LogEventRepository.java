package com.codenation.demo.logEvent.repository;

import com.codenation.demo.logEvent.model.LogEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogEventRepository extends CrudRepository<LogEvent, Long> {

    @Query("SELECT le.id, le.user, le.level, le.description, le.createdAt, le.number" +
            " FROM LogEvent le")
    Page<LogEvent> findAllPagingAndSorting(Pageable pageable);

    @Query("SELECT le "+
            "FROM LogEvent le " +
            "WHERE le.id = :id")
    Optional<LogEvent> findById(Long id);

    @Query("SELECT le.id, le.user, le.level, le.description, le.createdAt, le.number" +
            " FROM LogEvent le" +
            " WHERE le.user = :user")
    Page<LogEvent> findByUserPagingAndSorting(String user, Pageable pageable);

    @Query("SELECT le.id, le.user, le.level, le.description, le.createdAt, le.number" +
            " FROM LogEvent le" +
            " WHERE le.level = :level")
    Page<LogEvent> findByLevelPagingAndSorting(String level, Pageable pageable);

    @Query("SELECT le.id, le.user, le.level, le.description, le.createdAt, le.number" +
            " FROM LogEvent le" +
            " WHERE le.description = :description")
    Page<LogEvent> findByDescriptionPagingAndSorting(String description, Pageable pageable);

    @Query("SELECT le.id, le.user, le.level, le.description, le.createdAt, le.number" +
            " FROM LogEvent le" +
            " WHERE le.description like %:description")
    Page<LogEvent> findByDescriptionContainPagingAndSorting(String description, Pageable pageable);

    @Query("SELECT le.id, le.user, le.level, le.description, le.createdAt, le.number" +
            " FROM LogEvent le" +
            " WHERE le.log = :log")
    Page<LogEvent> findByLogPagingAndSorting(String log, Pageable pageable);

    @Query("SELECT le.id, le.user, le.level, le.description, le.createdAt, le.number" +
            " FROM LogEvent le" +
            " WHERE le.log like %:log")
    Page<LogEvent> findByLogContainPagingAndSorting(String log, Pageable pageable);

    @Query("SELECT le.id, le.user, le.level, le.description, le.createdAt, le.number" +
            " FROM LogEvent le" +
            " WHERE le.number = :number")
    Page<LogEvent> findByNumberPagingAndSorting(Long number, Pageable pageable);

}
