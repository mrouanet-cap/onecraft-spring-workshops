package io.onecraft.spring.domain.exception;

/**
 * The exception for when a technical design is not found.
 */
public class TechnicalDesignNotFoundException extends RuntimeException{

    /**
     * The constructor for the technical design not found exception.
     *
     * @param designId the design id.
     */
    public TechnicalDesignNotFoundException(Long designId) {
        super("Technical design with id " + designId + " not found");
    }
}
