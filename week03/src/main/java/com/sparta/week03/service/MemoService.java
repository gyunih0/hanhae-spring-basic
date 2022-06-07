package com.sparta.week03.service;


import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;


    @Transactional
    public Long update(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("id가 존재하지 않습니다.")
        );

        memo.update(memoRequestDto);
        return id;
    }

}
