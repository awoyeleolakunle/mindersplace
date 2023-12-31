package com.example.mindersplace.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Minder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String unitCity;
    private String jobTitle;
    private String applicationCode;
    private String country;
    private boolean isActive;
    private String certificateNumber;
    private String certificateImgUrl;
    private String firstAidNumber;
    private String firstAidImgUrl;
    private String foodQualificationNumber;
    private String foodQualificationImgUrl;
    private String level3AwardNumber;
    private String level3AwardImgUrl;
    private String personalIdNumber;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "clockInAndOut")
    private List<ClockRecord> clockRecord;

}
