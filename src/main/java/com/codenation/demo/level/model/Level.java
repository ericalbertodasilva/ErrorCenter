package com.codenation.demo.level.model;

import com.codenation.demo.logEvent.model.LogEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NotNull
    private String level;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
    private Set<LogEvent> logEvent;

}
