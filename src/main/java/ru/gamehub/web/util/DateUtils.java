package ru.gamehub.web.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Утилиты для работы с датами
 */
public class DateUtils {

    /**
     * Перевод дат
     *
     * @param timestamp
     * @return
     */
    public static OffsetDateTime timestampToOffsetDateTime(java.sql.Timestamp timestamp) {
        OffsetDateTime offsetDateTime = null;

        if (timestamp != null) {
            offsetDateTime = OffsetDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.UTC);
        }
        return offsetDateTime;
    }

    private DateUtils() {
    }
}
