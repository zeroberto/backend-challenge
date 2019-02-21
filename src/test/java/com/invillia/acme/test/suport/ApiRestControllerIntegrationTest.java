package com.invillia.acme.test.suport;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;

/**
 * Api Rest Controller Integration Test for any subclasses.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Getter(AccessLevel.PROTECTED)
public class ApiRestControllerIntegrationTest {

    private ObjectMapper objectMapper;

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void init() {
        this.objectMapper = new ObjectMapper();
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;
    }

    protected RequestSpecification begin() {
        return given()
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

}
