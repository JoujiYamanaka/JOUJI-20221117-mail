package apiSystem.util;

import java.util.Optional;
import java.util.stream.Stream;
import apiSystem.enums.EnumStringKeyAccesser;
import apiSystem.enums.EnumStringValueAccesser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Enumユーティリティ
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumUtil {
    public static <T extends Enum<T> & EnumStringKeyAccesser> Optional<T> of(String key, Class<T> enumClass){
        return Stream.of(enumClass.getEnumConstants())
                .filter(enums -> enums.getKey().equals(key))
                .findFirst();
    }

    public static <T extends Enum<T> & EnumStringValueAccesser> Optional<T> fromValue(String value, Class<T> enumClass){
        return Stream.of(enumClass.getEnumConstants())
                .filter(enums -> enums.getValue().equals(value))
                .findFirst();
    }
}
