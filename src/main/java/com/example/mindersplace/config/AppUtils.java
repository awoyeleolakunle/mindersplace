package com.example.mindersplace.config;


import com.example.mindersplace.mail.MailConfiguration;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppUtils {
    @Value("${mail.api.key}")
    private String mailApi;
    @Value("${sendinblue.mail.url}")
    private String mailUrl;


    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }


   @Bean
    public MailConfiguration mailConfiguration(){
        return new MailConfiguration(mailApi, mailUrl);
   }
}

