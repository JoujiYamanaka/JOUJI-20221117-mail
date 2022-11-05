package apiSystem.service;

import org.springframework.stereotype.Service;

import apiSystem.dto.ApplyPaidHolidaysDto;
import apiSystem.util.MessageSourceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@CommonsLog
@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender sender;
    private final VelocityEngine velocityEngine;

    /** キャラクターエンコード */
    private static final String ENCODE = "ISO-2022-JP";

    /**
     * メールを送信する
     */
    public void sendMail(ApplyPaidHolidaysDto applyPaidHolidaysDto) {

        MimeMessage mimeMessage = sender.createMimeMessage();
        
        try {
            mimeMessage.setHeader("Content-Type", "text/plain");
            //送信情報設定
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, ENCODE);
            helper.setFrom(applyPaidHolidaysDto.getApplicantMailAddress());
            helper.setTo(applyPaidHolidaysDto.getMailAddressByTo());
            helper.setCc(applyPaidHolidaysDto.getMailAddressByCc());
            helper.setSubject(getSubject(applyPaidHolidaysDto));
            helper.setText(getTextBody(applyPaidHolidaysDto));
            
            //メール送信
            sender.send(mimeMessage);
        } catch(MessagingException e) {
            log.error(MessageSourceUtil.getMessage("mailSendError"));
            log.error(e);
        }
    }
    
    /**
     * メールタイトルを取得する
     * @return メールタイトル
     */
    public String getSubject(ApplyPaidHolidaysDto applyPaidHolidaysDto) {
        String subject = null;
        switch (applyPaidHolidaysDto.getHolidayType()) {
            case ALL_DAYS_PAID_HOLIDAYS:
            case HALF_DAYS_PAID_HOLIDAYS:
                subject = "有給休暇申請";
                break;
            case COMPENSATORY_HOLIDAYS:
                subject = "代休休暇申請";
                break;
        }
        return subject;
    }

    /**
     * テンプレートを元にメール本文を取得する
     * @return メール本文
     */
    private String getTextBody(ApplyPaidHolidaysDto applyPaidHolidaysDto) {
        // パラメーター定義
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("to", applyPaidHolidaysDto.getNameByTo());
        velocityContext.put("cc", applyPaidHolidaysDto.getNameByCc());
        velocityContext.put("applicantName", applyPaidHolidaysDto.getApplicantName());
        velocityContext.put("holidayType", applyPaidHolidaysDto.getHolidayType().getValue());
        velocityContext.put("date", applyPaidHolidaysDto.getDate() );
        velocityContext.put("reason", applyPaidHolidaysDto.getReason());
        velocityContext.put("authorizer", applyPaidHolidaysDto.getAuthorizer());
        velocityContext.put("contact", applyPaidHolidaysDto.getContact());
        velocityContext.put("unusedPaidHolidays", applyPaidHolidaysDto.getUnusedPaidHolidays());

        // テンプレートの読み込み
        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("templates/paidHoliday.vm", "UTF-8", velocityContext, stringWriter);
        return stringWriter.toString();
    }
}
