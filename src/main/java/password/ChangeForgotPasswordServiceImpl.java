package password;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.mindersplace.dtos.request.EmailNotificationRequest;
import com.example.mindersplace.mail.MailConfiguration;

import com.example.mindersplace.services.UserService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;


@Service
@AllArgsConstructor

public class ChangeForgotPasswordServiceImpl  implements ChangeForgotPasswordService{

    private final UserService userService;
    private  final MailConfiguration mailConfiguration;


    @Override
    public ApiResponse sendResetPasswordLink(String recipientEmailAddress) {
        boolean isRegisteredUser = userService.findByEmailAddress(recipientEmailAddress)!= null;
        if (isRegisteredUser) {
            String token = generateToken();
            EmailNotificationRequest request = buildEmailRequest(recipientEmailAddress, token);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = buildHttpHeaders();
            HttpEntity<EmailNotificationRequest> requestHttpEntity = new HttpEntity<>(request, httpHeaders);
            ResponseEntity<String> response = restTemplate.postForEntity(mailConfiguration.getMailUrl(), requestHttpEntity, String.class);
            return GenerateApiResponse.createdResponse(response.getBody());
        }
        return GenerateApiResponse.notOkResponse(GenerateApiResponse.USER_NOT_FOUND);
    }

    private HttpHeaders buildHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("api_key", mailConfiguration.getApiKey());
        return httpHeaders;
    }

    private EmailNotificationRequest buildEmailRequest(String recipientEmailAddress, String token) {
        EmailNotificationRequest request = new EmailNotificationRequest();
        request.setRecipientEmailAddress(recipientEmailAddress);
        request.setSubject(GenerateApiResponse.EMAIL_SUBJECT);
        request.setHtmlContent(GenerateApiResponse.RESET_PASSWORD_LINK_FROM_FRONTEND+"?"+token);
        return request;
    }

    private String generateToken() {
         return JWT.create()
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusSeconds(300L))
                .sign(Algorithm.HMAC512("secret".getBytes()));
    }
}
