package com.codenation.demo;

import com.codenation.demo.logEvent.repository.LogEventRepository;
import com.codenation.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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

		/*Arrays.asList(
				User.builder().id(1L).name("Eric Silva").type("ADMIN").login("eadasilva").password("123").build(),
				User.builder().id(2L).name("Server legacy").type("SERVICE").login("serv").password("123").build(),
				User.builder().id(3L).name("Micro service").type("MICROSERVICE").login("mserv").password("123").build()
		).forEach(userRepository::save);*/

	}
}
