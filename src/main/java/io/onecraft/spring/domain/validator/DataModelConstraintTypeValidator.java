package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.DataModelConstraintType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Type of the data model constraint validator.
 *
 * @see DataModelConstraintType
 */
public class DataModelConstraintTypeValidator implements ConstraintValidator<DataModelConstraintType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "required", "unique", "email", "phone", "password", "username",
                "url", "date", "time", "datetime", "number", "integer", "float", "double", "boolean", "array", "object",
                "enum");
    }
}
