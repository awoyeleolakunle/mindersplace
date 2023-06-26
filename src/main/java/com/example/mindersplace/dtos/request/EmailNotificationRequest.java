package com.example.mindersplace.dtos.request;

import lombok.*;
import com.example.mindersplace.mail.Recipient;
import com.example.mindersplace.mail.Sender;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailNotificationRequest {
    private final Sender sender = new Sender("mindersplace.com", "NoReply@gmail.com");
    private String recipientEmailAddress;
    private String subject;
    private String htmlContent;
}
