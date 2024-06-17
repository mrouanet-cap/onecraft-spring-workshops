package io.onecraft.spring.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.onecraft.spring.adapter.gpt.GptOneCraftProjectTechnicalDesignRequest;
import io.onecraft.spring.adapter.gpt.GptProjectTechnicalDesign;
import io.onecraft.spring.adapter.support.GptAdapterMapper;
import io.onecraft.spring.domain.design.model.requirement.FunctionalRequirement;
import io.onecraft.spring.domain.design.model.OneCraftProjectTechnicalDesign;
import io.onecraft.spring.domain.spi.OneCraftProjectDesignProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
@ConditionalOnProperty(name = "onecraft.project.design.stub.enabled", havingValue = "false", matchIfMissing = true)
public class OneCraftProjectDesignGptProvider implements OneCraftProjectDesignProvider {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    private String gptUrl;

    private GptAdapterMapper mapper;

    /**
     * Injection constructor.
     *
     * @param mapper The mapper for the GPT-3 project technical design.
     * @param gptUrl The URL of the GPT-3 API.
     */
    public OneCraftProjectDesignGptProvider(GptAdapterMapper mapper, @Value("${gpt.api.url}") String gptUrl) {
        this.mapper = mapper;
        this.gptUrl = gptUrl;
    }

    @Override
    public OneCraftProjectTechnicalDesign createDesign(List<FunctionalRequirement> functionalRequirements) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(gptUrl))
                    .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .POST(HttpRequest.BodyPublishers.ofString(toGptPrompt(functionalRequirements)))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return fromGptResponse(response.body());
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts the functional requirements to a GPT-3 prompt.
     *
     * @param functionalRequirements The functional requirements of the project.
     * @return The GPT-3 prompt.
     */
    private String toGptPrompt(List<FunctionalRequirement> functionalRequirements) {
        try {
            return new ObjectMapper().writeValueAsString(new GptOneCraftProjectTechnicalDesignRequest("Given the following functional requirements:\n" +
                    String.join("\n",
                            functionalRequirements.stream().map(FunctionalRequirement::requirementDescription).toList()) +
                    "\n\nGenerate a technical design for the project.\n\n---\n\n"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts the GPT-3 response to a technical design.
     *
     * @param gptResponse The GPT-3 response.
     * @return The technical design of the project.
     */
    private OneCraftProjectTechnicalDesign fromGptResponse(String gptResponse) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        return mapper.toDomain(objectMapper.readValue(gptResponse, GptProjectTechnicalDesign.class));
    }
}
