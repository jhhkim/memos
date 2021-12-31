package com.example.memos.service;

import com.example.memos.doamain.memo.Memo;
import com.example.memos.doamain.memo.MemoRepository;
import com.example.memos.dto.MemoRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Memo save(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);  // 이렇게 해도 되고 // 빌더 만들어도 되겠네요
        return memoRepository.save(memo);
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("아이디가 없다." + id));
        
        memo.update(requestDto);
        return memo.getId();
    }
}