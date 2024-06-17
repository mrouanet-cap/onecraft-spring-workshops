package io.onecraft.spring.domain.exception;

public class OneCraftProjectNotFoundException extends RuntimeException {
    public OneCraftProjectNotFoundException(Long projectId) {
        super("OneCraft project not found with id: " + projectId);
    }
}
