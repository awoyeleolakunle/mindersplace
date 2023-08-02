package com.example.mindersplace.mail;

import com.example.mindersplace.dtos.request.EmailNotificationRequest;

public interface MailService {
    String sendMail(EmailNotificationRequest emailNotificationRequest);
}
