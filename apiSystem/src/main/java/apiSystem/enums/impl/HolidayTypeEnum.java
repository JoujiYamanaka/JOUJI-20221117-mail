package apiSystem.enums.impl;

import java.util.Optional;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

import apiSystem.enums.EnumStringKeyAccesser;
import apiSystem.enums.EnumStringValueAccesser;
import apiSystem.util.EnumUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 休日種別の定数
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum HolidayTypeEnum implements EnumStringKeyAccesser, EnumStringValueAccesser {
    ALL_DAYS_PAID_HOLIDAYS("0", "全日有給休暇"),
    HALF_DAYS_PAID_HOLIDAYS("1", "半日有給休暇"),
    COMPENSATORY_HOLIDAYS("2", "代休休暇");

    private String key;
    private String value;
    
    public static Optional<HolidayTypeEnum> of(String key) {
        return EnumUtil.of(key, HolidayTypeEnum.class);
    }
    
    public static Optional<HolidayTypeEnum> fromValue(String value) {
        return EnumUtil.fromValue(value, HolidayTypeEnum.class);
    }
    
    @JsonCreator
    public static HolidayTypeEnum getEnumFromValue(String key) {
        System.out.println("@JsonCreator");
        return Stream.of(HolidayTypeEnum.values())
                .filter(enumValue -> enumValue.getKey().equals(key))
                .findFirst()
                .orElse(null);
    }
}
