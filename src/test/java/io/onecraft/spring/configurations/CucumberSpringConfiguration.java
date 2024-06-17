package io.onecraft.spring.configurations;

import com.atlassian.oai.validator.wiremock.junit5.OpenApiValidator;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.cucumber.java.AfterStep;
import io.onecraft.spring.adapter.repository.OneCraftProjectRepository;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import com.github.tomakehurst.wiremock.WireMockServer;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import io.onecraft.spring.OneCraftSpringWorkshopsApplication;

/**
 * <p>
 * The class is annotated with @CucumberContextConfiguration, which is a Cucumber annotation used to specify that the
 * class is a test suite. A test suite is a collection of tests that are intended to be used to test a software program
 * to show that it has some specified set of behaviors.
 * </p>
 * <p>
 * The @SpringBootTest annotation is used to specify that the tests should be run using the Spring Boot application
 * context. This means that the tests will be run using the Spring Boot application context. The classes annotated with
 * {@link SpringBootTest} are used to test the Spring Boot application.
 * </p>
 */
@CucumberContextConfiguration
@SpringBootTest(classes = OneCraftSpringWorkshopsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {

    @Autowired
    private OneCraftProjectRepository oneCraftProjectRepository;

    public static final OpenApiValidator OPEN_API_VALIDATOR = new OpenApiValidator("schemas/gpt-design.json");

    // The WireMockServer is a class provided by the WireMock library. It is used to create a WireMock server for the tests.
    private final static WireMockServer wireMockServer = new WireMockServer(new WireMockConfiguration().port(8080).extensions(OPEN_API_VALIDATOR));

    // The PostgreSQLContainer is a class provided by the Testcontainers library. It is used to create a PostgreSQL container for the tests.
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15-alpine")
            .withDatabaseName("api-tests-db")
            .withUsername("sa")
            .withPassword("sa").waitingFor(Wait.forListeningPort());


    // The @LocalServerPort annotation is used to inject the port number of the server into the test class.
    // This allows the test class to know which port the server is running on.
    @LocalServerPort
    private int port;

    static {
        wireMockServer.start();
        postgreSQLContainer.start();
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        oneCraftProjectRepository.deleteAll();
    }

    @AfterStep
    public void resetWireMock() {
        OPEN_API_VALIDATOR.assertValidationPassed();
        OPEN_API_VALIDATOR.reset();
    }

    // The @DynamicPropertySource annotation is used to inject properties into the Spring Boot application context.
    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create");
        registry.add("spring.jpa.generate-ddl", () -> "true");
        registry.add("gpt.api.url", () -> wireMockServer.baseUrl() + "/v1/engines/davinci-codex/completions");
    }
}