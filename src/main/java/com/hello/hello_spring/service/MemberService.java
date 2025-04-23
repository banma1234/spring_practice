package com.hello.hello_spring.service;

import com.hello.hello_spring.domain.Member;
import com.hello.hello_spring.repository.MemberRepository;
import com.hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     * 회원가입
     * */
    public Long join(Member member) {
        // 중복회원 쳐내
        validateDuplicatedMember(member);
        repository.save(member);

        return member.getId();
    }

    /**
     * 전체회원 조회.
     * */
    public List<Member> findMembers() {
        return repository.findAll();
    }

    /**
     * 특정회원 id로 조회.
     * */
    public Optional<Member> findOne(long memberId) {
        return repository.findById(memberId);
    }

    /**
     * 중복회원 검증 및 에러 핸들링.
     * */
    private void validateDuplicatedMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 해당 회원이 존재합니다.");
                });
    }
}