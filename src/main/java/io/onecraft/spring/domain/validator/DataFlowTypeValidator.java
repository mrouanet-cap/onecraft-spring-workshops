package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.DataFlowType;
import jakarta.validation.ConstraintValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates the type of data flow between two components.
 *
 * @see DataFlowType
 */
public class DataFlowTypeValidator implements ConstraintValidator<DataFlowType, String> {
    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "event", "request", "response", "stream", "message", "signal",
                "data", "state", "command", "query", "task", "job", "process", "flow", "transfer", "exchange",
                "transfer", "transaction");
    }
}
