package io.onecraft.spring.adapter.support;

import jakarta.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.stream.Streams;

import java.util.List;

/**
 * This class represents a converter for a list of strings.
 *
 * @version 1.0
 */
public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return StringUtils.join(attribute, ";");
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return Streams.of(StringUtils.splitPreserveAllTokens(dbData, ";")).toList();
    }
}
