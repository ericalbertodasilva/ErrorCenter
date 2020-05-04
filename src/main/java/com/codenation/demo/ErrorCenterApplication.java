package com.codenation.demo;

import com.codenation.demo.logEvent.model.LogEvent;
import com.codenation.demo.logEvent.repository.LogEventRepository;
import com.codenation.demo.user.model.User;
import com.codenation.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping("/")
@SpringBootApplication
public class ErrorCenterApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ErrorCenterApplication.class, args);

	}
	@GetMapping
	public String health() {

		return "It's working!!!";
	}

	@Autowired
	LogEventRepository logEventRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		Arrays.asList(
				User.builder().id(1L).name("eric").login("eric").password("123").build(),
				User.builder().id(2L).name("Server legacy").login("server").password("123").build(),
				User.builder().id(3L).name("Micro service").login("micro").password("123").build()
		).forEach(userRepository::save);

		User user = userRepository.findById(1L).get();

		Arrays.asList(
				LogEvent.builder().id(1L).description("log").level("info").number(10L).log("log body").user(user).build(),
				LogEvent.builder().id(2L).description("log").level("warning").number(10L).log("log body").user(user).build(),
				LogEvent.builder().id(3L).description("log").level("error").number(10L).log("log body").user(user).build()
		).forEach(logEventRepository::save);

	}
}
