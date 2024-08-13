package com.wantedpreonboardingbackend.service;

import com.wantedpreonboardingbackend.domain.RecruitNotice;
import com.wantedpreonboardingbackend.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BoardService {

    final BoardMapper boardMapper;

    public Boolean addRecruit(RecruitNotice recruitNotice) {
        if (recruitNotice != null) {
            boardMapper.insertRecruit(recruitNotice);
            return true;
        }
        return false;
    }
}
