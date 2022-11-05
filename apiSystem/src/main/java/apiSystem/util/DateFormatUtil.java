package apiSystem.util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * DateFormatユーティリティ
 */
public class DateFormatUtil {

    /**
     * 現在日時をString型で取得（yyyyMMdd-HHmmss）
     */
    public static final String getNowTimestamp() {
        final LocalDateTime nowDateTime = java.time.LocalDateTime.now(); 
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return nowDateTime.format( dateTimeFormatter ).toString();
    }

    /**
     * 現在日時をString型で取得（yyyy/MM/dd）
     */
    public static final String getNowLocalDate() {
        final LocalDateTime nowDateTime = java.time.LocalDateTime.now(); 
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return nowDateTime.format( dateTimeFormatter ).toString();
    }

    /**
     * String型をLocalDateTime型に変換（yyyy/MM/dd）
     */
    public static final LocalDateTime getLocalDateTime(String date) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        final LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        return LocalDateTime.of(localDate, LocalTime.of(0,0));
    }

    /**
     * String型をLocalDate型に変換（yyyy/MM/dd）
     */
    public static final LocalDate getLocalDate(String date) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(date, dateTimeFormatter);
    }
}
