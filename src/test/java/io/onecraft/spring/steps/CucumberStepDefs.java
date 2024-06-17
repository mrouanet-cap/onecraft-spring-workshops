package io.onecraft.spring.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is used to provide common functionality for all Cucumber step definitions.
 *
 * @version 1.0
 */
public abstract class CucumberStepDefs {

    private final ObjectMapper objectMapper = new ObjectMapper();


    /**
     * This method is used to load data from a file and return it as a string. The file content is expected to be in
     * JSON format.
     *
     * @param fileName The name of the file to load.
     * @return The data from the file as a string.
     */
    protected String loadData(String fileName) {
        try {
            return objectMapper.writeValueAsString(
                    objectMapper.readTree(ResourceUtils.getFile("classpath:" + fileName)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to check if the response is as expected.
     *
     * @param response                 The response to check.
     * @param expectedResponseFileName The name of the file containing the expected response.
     */
    protected void checkResponse(String response, String expectedResponseFileName) {
        try {
            JsonNode expectedResponse = objectMapper.readTree(
                    ResourceUtils.getFile("classpath:" + expectedResponseFileName));
            ObjectNode actualResponse = (ObjectNode) objectMapper.readTree(response);
            // Remove the links from the actual response because they are not part of the expected response
            actualResponse.remove("_links");
            removeIdentifiers(actualResponse);
            removeDates(actualResponse);
            removeIdentifiers(expectedResponse);
            removeDates(expectedResponse);
            JSONAssert.assertEquals(expectedResponse.toString(), actualResponse.toString(), false);
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes recursively the "id" fields from a JsonNode and from all it's children.
     *
     * @param node the node to deal with
     */
    private void removeIdentifiers(JsonNode node) {
        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            Iterator<Map.Entry<String, JsonNode>> iterator = objectNode.fields();
            while (iterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = iterator.next();
                String fieldName = entry.getKey();
                if (fieldName.equals("id")) {
                    iterator.remove();
                } else {
                    removeIdentifiers(entry.getValue());
                }
            }
        } else if (node.isArray()) {
            node.forEach(this::removeIdentifiers);
        }
    }

    /**
     * Removes recursively the "id" fields from a JsonNode and from all it's children.
     *
     * @param node the node to deal with
     */
    private void removeDates(JsonNode node) {
        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            Iterator<Map.Entry<String, JsonNode>> iterator = objectNode.fields();
            while (iterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = iterator.next();
                String fieldName = entry.getKey();
                if (StringUtils.containsIgnoreCase(fieldName,"date")) {
                    iterator.remove();
                } else {
                    removeDates(entry.getValue());
                }
            }
        } else if (node.isArray()) {
            node.forEach(this::removeDates);
        }
    }
}
