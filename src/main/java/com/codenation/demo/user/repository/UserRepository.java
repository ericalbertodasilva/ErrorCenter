package com.codenation.demo.user.repository;

import com.codenation.demo.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {

    User findByLogin(String login);

}
