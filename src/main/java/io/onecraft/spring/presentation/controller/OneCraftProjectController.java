package io.onecraft.spring.presentation.controller;

import io.onecraft.spring.domain.api.OneCraftProjectDesignDomain;
import io.onecraft.spring.domain.api.OneCraftProjectDomain;
import io.onecraft.spring.presentation.model.OneCraftProjectCreationRequestDto;
import io.onecraft.spring.presentation.model.OneCraftProjectDesignCreationRequestDto;
import io.onecraft.spring.presentation.model.OneCraftProjectDto;
import io.onecraft.spring.presentation.model.OneCraftProjectTechnicalDesignDto;
import io.onecraft.spring.presentation.support.OneCraftProjectResourceAssembler;
import io.onecraft.spring.presentation.support.OneCraftProjectTechnicalDesignResourceAssembler;
import io.onecraft.spring.presentation.support.PresentationMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.LinkParameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "OneCraft Project")
@RequestMapping("/api/onecraft/v1/projects")
public class OneCraftProjectController {

    private final OneCraftProjectDomain oneCraftProjectDomain;

    private final OneCraftProjectDesignDomain oneCraftProjectDesignDomain;

    private final PresentationMapper presentationMapper;

    private final OneCraftProjectResourceAssembler oneCraftProjectResourceAssembler;

    private final OneCraftProjectTechnicalDesignResourceAssembler oneCraftProjectTechnicalDesignResourceAssembler;

    /**
     * The constructor for the OneCraft project controller.
     *
     * @param oneCraftProjectDomain            The domain for the OneCraft project.
     * @param presentationMapper               The mapper for the presentation layer.
     * @param oneCraftProjectResourceAssembler The resource assembler for the OneCraft project.
     */
    public OneCraftProjectController(OneCraftProjectDomain oneCraftProjectDomain, OneCraftProjectDesignDomain oneCraftProjectDesignDomain, PresentationMapper presentationMapper, OneCraftProjectResourceAssembler oneCraftProjectResourceAssembler, OneCraftProjectTechnicalDesignResourceAssembler oneCraftProjectTechnicalDesignResourceAssembler) {
        this.oneCraftProjectDomain = oneCraftProjectDomain;
        this.oneCraftProjectDesignDomain = oneCraftProjectDesignDomain;
        this.presentationMapper = presentationMapper;
        this.oneCraftProjectResourceAssembler = oneCraftProjectResourceAssembler;
        this.oneCraftProjectTechnicalDesignResourceAssembler = oneCraftProjectTechnicalDesignResourceAssembler;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Create a new project", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Project created"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public EntityModel<OneCraftProjectDto> createProject(@Valid @RequestBody OneCraftProjectCreationRequestDto creationRequestDto) {
        return oneCraftProjectResourceAssembler.toModel(
                oneCraftProjectDomain.createProject(presentationMapper.toModel(creationRequestDto)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/{projectId}/designs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Create a new design for a project", operationId = "createDesign", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Design created", links = {
                    @io.swagger.v3.oas.annotations.links.Link(name = "self", operationId = "getDesignById", parameters = {@LinkParameter(name = "designId", expression = "$response.body.id")})
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Project not found")
    })
    public EntityModel<OneCraftProjectTechnicalDesignDto> createDesign(@PathVariable Long projectId, @Valid @RequestBody OneCraftProjectDesignCreationRequestDto creationRequestDto) {
        return oneCraftProjectTechnicalDesignResourceAssembler.toModel(
                oneCraftProjectDesignDomain.designProject(projectId, presentationMapper.toModel(creationRequestDto)));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{projectId}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Get a project", operationId = "getProjectById", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Project found", links = {
                    @io.swagger.v3.oas.annotations.links.Link(description = "Available only if the project is designable", name = "create_design", operationId = "createDesign", parameters = {@LinkParameter(name = "projectId", expression = "$response.body.id")}),
                    @io.swagger.v3.oas.annotations.links.Link(name = "self", operationId = "getOneCraftProject", parameters = {@LinkParameter(name = "projectId", expression = "$response.body.id")})
            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Project not found")
    })
    public EntityModel<OneCraftProjectDto> getOneCraftProject(@PathVariable Long projectId) {
        return oneCraftProjectResourceAssembler.toModel(oneCraftProjectDomain.getProject(projectId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/{projectId}/close", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Close a project", operationId = "closeProject", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Project closed", links = {
                    @io.swagger.v3.oas.annotations.links.Link(name = "self", operationId = "getOneCraftProject", parameters = {@LinkParameter(name = "projectId", expression = "$response.body.id")})
            })})
    public EntityModel<OneCraftProjectDto> closeProject(@PathVariable Long projectId) {
        return oneCraftProjectResourceAssembler.toModel(oneCraftProjectDomain.closeProject(projectId));
    }
}
