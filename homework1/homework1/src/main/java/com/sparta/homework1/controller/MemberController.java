package com.sparta.homework1.controller;


import com.sparta.homework1.domain.Member;
import com.sparta.homework1.domain.MemberDto;
import com.sparta.homework1.repository.MemberRepository;
import com.sparta.homework1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MemberController {

    private final MemberService memberService;



    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public List<Member> getMembers() {
        return memberService.findMembers();
    }

    @PostMapping("/member")
    public long createMember(@RequestBody MemberDto memberDto) {
        Member member = new Member(memberDto);
        return memberService.join(member);
    }

    @PutMapping("/member/{id}")
    public Long updateMember(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        return memberService.update(id, memberDto);
    }

    @DeleteMapping("/member/{id}")
    public Long deleteMember(@PathVariable Long id) {
        return memberService.delete(id);
    }
}
