package com.wantedpreonboardingbackend.controller;

import com.wantedpreonboardingbackend.domain.RecruitNotice;
import com.wantedpreonboardingbackend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    final BoardService boardService;

    @PostMapping("/")
    public ResponseEntity<Object> addRecruit(RecruitNotice recruitNotice) {
        if (boardService.validate(recruitNotice)) {
            boardService.addRecruit(recruitNotice);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/list")
    public List<Map<String, Object>> getList() {
        return boardService.getList();
    }
}
