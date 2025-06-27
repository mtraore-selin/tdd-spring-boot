package com.social.platform.social;

import com.social.platform.social.entities.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void registerUser_whenInputIsValid_returnsOkResponse() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUserName("johndoe123");
        user.setEmail("john.doe@example.com"); // ✅ valid email
        user.setPassword("StrongPassword123");

        ResponseEntity<Object> response = testRestTemplate.postForEntity(
                "/api/v1/users",
                user,
                Object.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void registerUser_whenEmailIsInvalid_returnsBadRequest() {
        User user = new User();
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setUserName("janedoe123");
        user.setEmail("invalid-email"); // ❌ not a valid email
        user.setPassword("AnotherStrongPass123");

        ResponseEntity<Object> response = testRestTemplate.postForEntity(
                "/api/v1/users",
                user,
                Object.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}

