package io.onecraft.spring.presentation.controller;

import io.onecraft.spring.domain.api.OneCraftProjectDesignDomain;
import io.onecraft.spring.presentation.model.OneCraftProjectTechnicalDesignDto;
import io.onecraft.spring.presentation.support.OneCraftProjectTechnicalDesignResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.LinkParameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * The controller for the OneCraft technical design.
 *
 * @version 1.0
 */
@RestController
@Tag(name = "OneCraft Technical Design")
@RequestMapping("/api/onecraft/v1/designs")
public class OneCraftTechnicalDesignController {

    private final OneCraftProjectDesignDomain oneCraftProjectDesignDomain;

    private final OneCraftProjectTechnicalDesignResourceAssembler oneCraftProjectTechnicalDesignResourceAssembler;

    /**
     * Injection constructor.
     *
     * @param oneCraftProjectDesignDomain                     instance of the OneCraft project design domain
     * @param oneCraftProjectTechnicalDesignResourceAssembler instance of the OneCraft project technical design resource
     *                                                        assembler
     */
    public OneCraftTechnicalDesignController(OneCraftProjectDesignDomain oneCraftProjectDesignDomain, OneCraftProjectTechnicalDesignResourceAssembler oneCraftProjectTechnicalDesignResourceAssembler) {
        this.oneCraftProjectDesignDomain = oneCraftProjectDesignDomain;
        this.oneCraftProjectTechnicalDesignResourceAssembler = oneCraftProjectTechnicalDesignResourceAssembler;
    }

    /**
     * Get a technical design.
     *
     * @param designId the design id
     * @return the found technical design
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{designId}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Get a technical design", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Design found", links = {
                    @io.swagger.v3.oas.annotations.links.Link(name = "self", operationId = "getDesignById", parameters = {
                            @LinkParameter(name = "projectId", expression = "$response.body.id")
                    }),
                    @io.swagger.v3.oas.annotations.links.Link(description = "Available only if the design is approvable", name = "approve", operationId = "approveDesign", parameters = {
                            @LinkParameter(name = "projectId", expression = "$response.body.id")
                    })
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Design not found")
    })
    public EntityModel<OneCraftProjectTechnicalDesignDto> getTechnicalDesign(@PathVariable Long designId) {
        return oneCraftProjectTechnicalDesignResourceAssembler.toModel(
                oneCraftProjectDesignDomain.getDesign(designId));
    }

    /**
     * Approve a technical design.
     *
     * @param designId the design id
     * @return the updated technical design
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/{designId}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Approve a technical design", operationId = "approveDesign", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Design updated")})
    public EntityModel<OneCraftProjectTechnicalDesignDto> approveTechnicalDesign(@PathVariable Long designId) {
        return oneCraftProjectTechnicalDesignResourceAssembler.toModel(
                oneCraftProjectDesignDomain.approveDesign(designId));
    }
}
