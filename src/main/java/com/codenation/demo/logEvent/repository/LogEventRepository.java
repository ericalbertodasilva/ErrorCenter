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

    @Query("SELECT le" +
            " FROM LogEvent le")
    Page<LogEvent> findAllPagingAndSorting(Pageable pageable);

    @Query("SELECT le "+
            "FROM LogEvent le " +
            "WHERE le.id = :id")
    Optional<LogEvent> findById(Long id);

    @Query(value = "select id, user, level, description, created_at, number "+
            "FROM LOG_EVENT le " +
            "INNER JOIN USER u " +
            "ON le.user = u.id " +
            "where le.user = :user", nativeQuery = true)
    Page<LogEvent> findByUserPagingAndSorting(String user, Pageable pageable);

    @Query(value = "select id, user, level, description, created_at, number "+
            "from LOG_EVENT le" +
            "INNER JOIN USER ui" +
            "ON le.user = ui.id" +
            "where le.level = :level", nativeQuery = true)
    Page<LogEvent> findByLevelPagingAndSorting(String level, Pageable pageable);

    @Query(value = "select id, user, level, description, created_at, number "+
            "from LOG_EVENT le" +
            "INNER JOIN USER ui" +
            "ON le.user = ui.id" +
            "where le.description = :description", nativeQuery = true)
    Page<LogEvent> findByDescriptionPagingAndSorting(String description, Pageable pageable);

    @Query(value = "select id, user, level, description, created_at, number "+
            "from LOG_EVENT le" +
            "INNER JOIN USER ui" +
            "ON le.user = ui.id" +
            "where le.description like %:description", nativeQuery = true)
    Page<LogEvent> findByDescriptionContainPagingAndSorting(String description, Pageable pageable);

    @Query(value = "select id, user, level, description, created_at, number "+
            "from LOG_EVENT le" +
            "INNER JOIN USER ui" +
            "ON le.user = ui.id" +
            "where le.log = :log", nativeQuery = true)
    Page<LogEvent> findByLogPagingAndSorting(String log, Pageable pageable);

    @Query(value = "select id, user, level, description, created_at, number "+
            "from LOG_EVENT le" +
            "INNER JOIN USER ui" +
            "ON le.user = ui.id" +
            "where le.log like %:log", nativeQuery = true)
    Page<LogEvent> findByLogContainPagingAndSorting(String log, Pageable pageable);

    @Query(value = "select id, user, level, description, created_at, number "+
            "from LOG_EVENT le" +
            "INNER JOIN USER ui" +
            "ON le.user = ui.id" +
            "where le.number = :number", nativeQuery = true)
    Page<LogEvent> findByNumberPagingAndSorting(Long number, Pageable pageable);

}
