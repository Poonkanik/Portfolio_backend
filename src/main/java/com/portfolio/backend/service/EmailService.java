package com.portfolio.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class EmailService {

    @Value("${RESEND_API_KEY}")
    private String apiKey;

    @Value("${EMAIL_TO}")
    private String emailTo;

    @Value("${EMAIL_FROM}")
    private String emailFrom;

    private static final String RESEND_URL = "https://api.resend.com/emails";

    public void sendContactEmail(String name, String email, String message) {

        RestTemplate rest = new RestTemplate();

        Map<String, Object> body = Map.of(
                "from", emailFrom,
                "to", emailTo,
                "subject", "New Contact Form Message",
                "html", "<p><strong>Name:</strong> " + name + "</p>"
                        + "<p><strong>Email:</strong> " + email + "</p>"
                        + "<p><strong>Message:</strong><br/>" + message + "</p>");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        rest.postForEntity(RESEND_URL, request, String.class);
    }
}
