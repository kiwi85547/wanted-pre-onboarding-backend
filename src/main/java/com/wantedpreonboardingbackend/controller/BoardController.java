package com.wantedpreonboardingbackend.controller;

import com.wantedpreonboardingbackend.domain.RecruitNotice;
import com.wantedpreonboardingbackend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<Object> addRecruit(@RequestBody RecruitNotice recruitNotice) {
        if (boardService.validate(recruitNotice)) {
            boardService.addRecruit(recruitNotice);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("list")
    public List<Map<String, Object>> getList() {
        return boardService.getList();
    }

    @GetMapping("{id}")
    public ResponseEntity getRecruitById(@PathVariable Integer id) {
        Map<String, Object> map = boardService.getBoard(id);
        if (map == null || map.get("recruit") == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(map);
    }

    @PutMapping("{id}")
    public ResponseEntity modifyRecruit(@PathVariable Integer id, @RequestBody RecruitNotice recruitNotice) {
        if (boardService.validate(recruitNotice)) {
            Map<String, Object> result = boardService.modifyRecruit(id, recruitNotice);
            if (result == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRecruit(@PathVariable Integer id) {
        if (id == null || !boardService.deleteRecruit(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
