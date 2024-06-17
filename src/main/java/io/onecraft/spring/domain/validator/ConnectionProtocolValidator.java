package io.onecraft.spring.domain.validator;

import io.onecraft.spring.domain.annotation.ConnectionProtocol;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * Validates a connection protocol.
 *
 * @version 1.0
 */
public class ConnectionProtocolValidator implements ConstraintValidator<ConnectionProtocol, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.containsAnyIgnoreCase(value, "HTTP", "HTTPS", "FTP", "SFTP", "SSH");
    }
}
