package com.example.mindersplace.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QualificationRequest {

    private String certificateNumber;
    private String certificateImgUrl;
    private String firstAidNumber;
    private String firstAidImgUrl;
    private String foodQualificationNumber;
    private String foodQualificationImgUrl;
    private String level3AwardNumber;
    private String level3AwardImgUrl;
}
