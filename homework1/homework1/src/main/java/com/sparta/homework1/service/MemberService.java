package com.sparta.homework1.service;


import com.sparta.homework1.domain.Member;
import com.sparta.homework1.domain.MemberDto;
import com.sparta.homework1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional
    public Long update(Long id, MemberDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );

        member.update(memberDto);
        return member.getId();

    }

    public Long delete(Long id) {
        memberRepository.deleteById(id);
        return id;
    }


}
