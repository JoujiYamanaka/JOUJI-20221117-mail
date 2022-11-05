package apiSystem.util;

import java.util.Locale;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * MessageSourceユーティリティ
 */
public class MessageSourceUtil{
    
    /**
     * メッセージの取得
     * @param code
     * @return
     */
    public static final String getMessage(String code) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.addBasenames("classpath:/messages_ja");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        String message = messageSource.getMessage(code, null, Locale.JAPANESE.stripExtensions());

        return message;
    }

    /**
     * メッセージの取得 
     * @param code
     * @param value
     * @return
     */
    public static final String getMessage(String code, String value) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.addBasenames("classpath:/messages_ja");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        String message = messageSource.getMessage(code, new String[]{value}, Locale.JAPANESE.stripExtensions());

        return message;
    }
}