package com.example.mindersplace.services.mindersQualification;

import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.dtos.request.QualificationRequest;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MinderQualificationServiceImp implements MinderQualificationsService {
    private final MinderService minderService;

    @Override
    public ApiResponse saveMinderQualifications(String minderEmailAddress, QualificationRequest qualificationRequest) {
       if(! isValidated(minderEmailAddress)) {return ApiResponse.builder()
               .data(GenerateApiResponse.USER_NOT_FOUND)
               .isSuccessful(false)
               .httpStatus(HttpStatus.BAD_REQUEST)
               .statusCode(HttpStatus.BAD_REQUEST.value())
               .build();}

        Minder minder = mapMinderQualification(minderEmailAddress, qualificationRequest);

        return ApiResponse.builder()
                .data(GenerateApiResponse.UPLOAD_SUCCESSFUL)
                .isSuccessful(true)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    private boolean isValidated(String minderEmailAddress) {
        return minderService.findByEmailAddress(minderEmailAddress)!=null;

    }

    private Minder mapMinderQualification(String minderEmailAddress, QualificationRequest qualificationRequest){
        Minder minder = minderService.findByEmailAddress(minderEmailAddress);
        minder.setCertificateNumber(qualificationRequest.getCertificateNumber());
        minder.setCertificateImgUrl(qualificationRequest.getCertificateImgUrl());
        minder.setFirstAidNumber(qualificationRequest.getFirstAidNumber());
        minder.setFirstAidImgUrl(qualificationRequest.getFirstAidImgUrl());
        minder.setFoodQualificationNumber(qualificationRequest.getFoodQualificationNumber());
        minder.setFoodQualificationImgUrl(qualificationRequest.getFoodQualificationImgUrl());
        minder.setLevel3AwardNumber(qualificationRequest.getLevel3AwardNumber());
        minder.setLevel3AwardImgUrl(qualificationRequest.getLevel3AwardImgUrl());
        return minderService.saveMinder(minder);
    }
}
