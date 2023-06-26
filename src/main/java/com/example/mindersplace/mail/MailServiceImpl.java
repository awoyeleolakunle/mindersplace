package com.example.mindersplace.mail;

import com.example.mindersplace.dtos.request.EmailNotificationRequest;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService{

    private final MailConfiguration mailConfiguration;
    @Override
    public String sendMail( String recipientEmailAddress) {
        EmailNotificationRequest request = new EmailNotificationRequest();
        request.setRecipientEmailAddress(recipientEmailAddress);
        request.setSubject(GenerateApiResponse.EMAIL_SUBJECT);
        request.setHtmlContent(GenerateApiResponse.EMAIL_CONTENT);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("api_key", mailConfiguration.getApiKey());
        HttpEntity<EmailNotificationRequest> requestHttpEntity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<String > response = restTemplate.postForEntity(mailConfiguration.getMailUrl(), requestHttpEntity, String.class);
        return response.getBody();
    }
}
