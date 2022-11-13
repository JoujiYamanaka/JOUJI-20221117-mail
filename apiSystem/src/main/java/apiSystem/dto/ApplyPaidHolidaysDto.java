package apiSystem.dto;

import apiSystem.enums.impl.HolidayTypeEnum;
import apiSystem.util.DateFormatUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 有給休暇申請Dto
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplyPaidHolidaysDto {
    /** 申請者のメールアドレス */
    private String applicantMailAddress;
    /** 宛先の氏名 */
    private String nameByTo;
    /** 宛先のメールアドレス */
    private String mailAddressByTo;
    /** CCの氏名 */
    private String nameByCc;
    /** CCのメールアドレス */
    private String mailAddressByCc;
    /** 申請者名 */
    private String applicantName;
    /** 休日種別 */
    private HolidayTypeEnum holidayType;
    /** 実施日時 */
    private String date;
    /** 事由 */
    private String reason;
    /** 連絡先 */
    private String contact;
    /** 承認者 */
    private String authorizer;
    /** 残有給休暇日数 */
    private Integer unusedPaidHolidays;
    
    public static ApplyPaidHolidaysDto build() {
    	String mailAddress = "";
        return ApplyPaidHolidaysDto.builder()
                .applicantMailAddress(mailAddress)
                .nameByTo("テスト事務部長")
                .mailAddressByTo(mailAddress)
                .nameByCc("テスト花子")
                .mailAddressByCc(mailAddress)
                .applicantName("テスト次郎")
                .holidayType(HolidayTypeEnum.ALL_DAYS_PAID_HOLIDAYS)
                .date(DateFormatUtil.getNowLocalDate())
                .reason("休養のため")
                .contact("xxx-xxxx-xxxx")
                .authorizer("テスト太郎")
                .unusedPaidHolidays(10)
                .build();
    }
}
