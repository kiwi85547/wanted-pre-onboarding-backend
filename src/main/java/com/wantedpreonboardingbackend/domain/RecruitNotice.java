package com.wantedpreonboardingbackend.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecruitNotice {
    private Integer recruitId;
    private Integer companyId;
    private String position;
    private Integer salary;
    private String content;
    private String techStack;
    private String country;
    private String region;
    private LocalDateTime createdAt;
}
