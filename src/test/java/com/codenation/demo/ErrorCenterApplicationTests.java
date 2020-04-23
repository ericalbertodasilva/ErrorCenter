package com.codenation.demo;

import com.codenation.demo.logEvent.model.LogEvent;
import com.codenation.demo.user.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ErrorCenterApplicationTests {

	@Test
	void contextLoads() {
	}
/*
	@Test(expected = JsonMappingException.class)
	public void givenBidirectionRelation_whenSerializing_thenException()
			throws JsonProcessingException {

		User user = new User();
		LogEvent logEvent = new LogEvent();
		user.addLogEvent(item);

		new ObjectMapper().writeValueAsString(logEvent);
	}

	@Test
	public void
	givenBidirectionRelation_whenUsingJacksonReferenceAnnotation_thenCorrect()
			throws JsonProcessingException {

		User user = new User();
		LogEvent logEvent = new LogEvent();
		user.addLogEvent(logEvent);

		String result = new ObjectMapper().writeValueAsString(logEvent);

		assertThat(result, containsString("book"));
		assertThat(result, containsString("John"));
		assertThat(result, not(containsString("userItems")));
	}*/

}
