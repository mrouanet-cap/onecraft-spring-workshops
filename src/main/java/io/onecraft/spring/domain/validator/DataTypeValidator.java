package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.DataType;
import jakarta.validation.ConstraintValidator;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates a data type.
 *
 * @see DataType
 */
public class DataTypeValidator implements ConstraintValidator<DataType, String> {
    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "int", "integer", "long", "float", "double", "string",
                "boolean", "date", "time", "datetime", "timestamp", "object", "array");
    }
}
