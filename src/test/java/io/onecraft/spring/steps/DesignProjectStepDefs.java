package io.onecraft.spring.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.springframework.http.MediaType;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.onecraft.spring.presentation.model.OneCraftProjectCreationRequestDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is used to define the step for the Cucumber tests. The step definitions are used to specify the behavior
 * of the application in plain meaningful English text.
 */
public class DesignProjectStepDefs extends CucumberStepDefs {

    private Long createdProjectId;

    private Response designResponse;

    @Given("A project manager creates a new project")
    public void aProjectManagerCreatesANewProject() {
        RequestSpecification request = RestAssured.given();
        Response creationResponse = request.contentType(MediaType.APPLICATION_JSON_VALUE).body(
                new OneCraftProjectCreationRequestDto("Project 1")).when().post(
                "/api/onecraft/v1/projects");
        assertThat(creationResponse.getStatusCode()).isEqualTo(201);
        createdProjectId = creationResponse.getBody().jsonPath().getLong("id");
    }

    @When("The project manager gives valid requirements")
    public void theProjectManagerGivesValidRequirements() {
        String requestBody = loadData("requests/valid_requirements.json");
        RequestSpecification request = RestAssured.given();
        designResponse = request.contentType(MediaType.APPLICATION_JSON_VALUE).body(requestBody).when().post(
                "/api/onecraft/v1/projects/%d/designs".formatted(createdProjectId));
        assertThat(designResponse.getStatusCode()).isEqualTo(201);
    }

    @Then("The solution architect should produce a valid technical design")
    public void theSolutionArchitectShouldProduceAValidTechnicalDesign() {
        assertThat(designResponse.getStatusCode()).isEqualTo(201);
        checkResponse(designResponse.getBody().asString(), "expected_responses/valid_design_creation.json");
    }

    @When("The project manager gives invalid requirements")
    public void theProjectManagerGivesInvalidRequirements() {
        String requestBody = loadData("requests/invalid_requirements.json");
        RequestSpecification request = RestAssured.given();
        designResponse = request.contentType(MediaType.APPLICATION_JSON_VALUE).body(requestBody).when().post(
                "/api/onecraft/v1/projects/%d/designs".formatted(createdProjectId));
    }

    @Then("The solution architect should fail to produce the design")
    public void theSolutionArchitectShouldFailToProduceTheDesign() {
        assertThat(designResponse.getStatusCode()).isEqualTo(400);
    }
}
