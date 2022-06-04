package com.sparta.homework1.service;

import com.sparta.homework1.domain.Member;
import com.sparta.homework1.domain.MemberDto;
import com.sparta.homework1.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("진유진 만들기는 성공해야한다.")
    void join() {
        MemberDto memberDto = new MemberDto();
        memberDto.setName("진유진");

        Member member = new Member(memberDto);
        System.out.println("member = " + member);

        memberRepository.save(member);
        Member savedMember = memberRepository.findById(member.getId()).get();


        Assertions.assertThat(savedMember.getId()).isEqualTo(member.getId());
    }

}
