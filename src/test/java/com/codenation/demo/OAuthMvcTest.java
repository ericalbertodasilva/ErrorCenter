package com.codenation.demo;

import com.codenation.demo.user.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = ErrorCenterApplication.class)
public class OAuthMvcTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private UserRepository userRepository;

    private MockMvc mockMvc;

    private static final String CLIENT_ID = "1";
    private static final String CLIENT_SECRET = "123";

    private static final String CONTENT_TYPE = "application/json";

    private static final String NAME = "eric";

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilter(springSecurityFilterChain).build();
    }

    private String obtainAccessToken(String username, String password) throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("username", "eric");
        params.add("password", "123");

        ResultActions result = mockMvc.perform(post("/oauth/token")
                .params(params)
                .with(httpBasic(username, password))
                .accept(CONTENT_TYPE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Test
    public void givenNoToken_whenGetSecureRequest_thenUnauthorized() throws Exception {
        mockMvc.perform(get("/logEvent")
                .param("id", CLIENT_ID))
                .andExpect(
                        status().isUnauthorized()
                );
    }
/*
    @Test
    public void givenInvalidRole_whenGetSecureRequest_thenForbidden() throws Exception {
        final String accessToken = obtainAccessToken("eric", "123");
        System.out.println("token:" + accessToken);
        mockMvc.perform(get("/logEvent")
                .header(
                        "Authorization",
                        "Bearer "
                                + accessToken
                )).andExpect(
                        status().isForbidden()
                );
    }

    @Test
    public void givenToken_whenPostGetSecureRequest_thenOk() throws Exception {
        final String accessToken = obtainAccessToken("admin", "nimda");

        String employeeString = "{\"name\":\"" + NAME + "\",\"age\":30}";

        // @formatter:off

        mockMvc.perform(post("/employee")
                .header("Authorization", "Bearer " + accessToken)
                .contentType(CONTENT_TYPE)
                .content(employeeString)
                .accept(CONTENT_TYPE))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/employee")
                .param("id", CLIENT_ID)
                .header("Authorization", "Bearer " + accessToken)
                .accept(CONTENT_TYPE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.name", is(NAME)));

    }*/
}
