package apiSystem.util;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * ResponseEntityユーティリティ
 */
public class ResponseEntityUtil {
    /**
     * ResponseEntityを作成
     */
    public static final ResponseEntity<Map<String, Object>> setResponseEntity(Object errorMessages, HttpStatus httpStatus, Object results) {
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));
        headers.setCacheControl("no-store");
        headers.setPragma("no-store");
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("messages", errorMessages);
        map.put("status", httpStatus.value());
        map.put("results", results);
        
        return new ResponseEntity<Map<String, Object>>(map, headers, httpStatus);
    }
}
