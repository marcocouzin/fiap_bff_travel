package br.com.fiap.fiap_bff_travel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.Date;


public class Util {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Util.class);

    public static Long numberOfNights(Date initialDate, Date endDate){
        long nights;
        nights = ((endDate.getTime() - initialDate.getTime()) / (1000 * 60 * 60 * 24));
        return nights;
    }


    public static void logNavigation(String message) {
        logger.info(message);
    }


    public static void logJson(String message, Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        logger.info(message + " - " + mapper.writeValueAsString(obj));
    }


    public static HttpEntity<String> createHttpEntityHeader(String userAgent) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        headers.set("User-Agent", userAgent);
        return new HttpEntity<>(headers);
    }


    public static HttpHeaders createHttpHeader(String userAgent) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        headers.set("User-Agent", userAgent);
        return headers;
    }
}
