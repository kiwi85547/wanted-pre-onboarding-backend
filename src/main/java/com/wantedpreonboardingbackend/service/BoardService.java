package com.wantedpreonboardingbackend.service;

import com.wantedpreonboardingbackend.domain.RecruitNotice;
import com.wantedpreonboardingbackend.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardService {

    final BoardMapper boardMapper;

    public boolean validate(RecruitNotice recruitNotice) {
        // 문자열 필드에 대한 체크
        String[] fieldsToCheck = {
                recruitNotice.getPosition(),
                recruitNotice.getContent(),
                recruitNotice.getTechStack(),
                recruitNotice.getCountry(),
                recruitNotice.getRegion(),
        };

        // null이거나 blank인지 체크
        for (String field : fieldsToCheck) {
            if (field == null || field.isBlank()) {
                return false;
            }
        }

        // Integer 필드에 대한 체크
        if (recruitNotice.getSalary() == null) {
            return false;
        }
        if (recruitNotice.getCompanyId() == null) {
            return false;
        }

        return true;
    }

    public void addRecruit(RecruitNotice recruitNotice) {
        boardMapper.insertRecruit(recruitNotice);
    }

    public List<Map<String, Object>> getList() {
        return boardMapper.selectList();
    }
}
