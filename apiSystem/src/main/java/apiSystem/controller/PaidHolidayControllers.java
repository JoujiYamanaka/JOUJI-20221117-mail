package apiSystem.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import apiSystem.dto.ApplyPaidHolidaysDto;
import apiSystem.service.MailService;
import apiSystem.util.MessageSourceUtil;
import apiSystem.util.ResponseEntityUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/paidHolidays")
@RequiredArgsConstructor
@Validated
public class PaidHolidayControllers {
    private final MailService mailService;

    /**
     * 1.有給休暇申請
     * @return ResponseEntity
     */
    @PostMapping(value = "/apply", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> applyPaidHolidays() {

    	// 有給休暇の申請情報作成
        ApplyPaidHolidaysDto applyPaidHolidaysDto = ApplyPaidHolidaysDto.build();

        // メール送信
        mailService.sendMail(applyPaidHolidaysDto);

        return ResponseEntityUtil.setResponseEntity(MessageSourceUtil.getMessage("mailSendSuccess"), HttpStatus.OK, HttpStatus.OK.name());
    }
}