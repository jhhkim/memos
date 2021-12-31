package com.example.memos.web;

import com.example.memos.dto.MemoRequestDto;
import com.example.memos.service.MemoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoService memoService;

    // Create
    @PostMapping("/api/v1/memo")
    public String memoSave(@RequestBody MemoRequestDto requestDto) {
        memoService.save(requestDto);
        return "ok";
    }

    // Read
    

    // Update
    @PostMapping("/api/v1/memo/{id}")
    public String memoUpdate(Long id, MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return "update complete";
    }

    // Delete
}
