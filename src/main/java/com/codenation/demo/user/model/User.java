package com.codenation.demo.user.model;

import com.codenation.demo.logEvent.model.LogEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NotNull
    @Size(max = 25)
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<LogEvent> logEvent;

    @Column
    @NotNull
    @Size(max = 100)
    private String login;

    @Column
    @NotNull
    @Size(max = 255)
    private String password;
}
