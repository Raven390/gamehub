package ru.gamehub.web.util;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.OffsetDateTime;
import java.time.Instant;
import java.time.ZoneOffset;

@Converter(autoApply = false)
public class OffsetDateTimeConverter implements AttributeConverter<OffsetDateTime, Long> {

    @Override
    public Long convertToDatabaseColumn(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return offsetDateTime.toInstant().toEpochMilli();
    }

    @Override
    public OffsetDateTime convertToEntityAttribute(Long timestamp) {
        if (timestamp == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.UTC);
    }
}
