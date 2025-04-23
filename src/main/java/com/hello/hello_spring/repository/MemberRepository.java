package com.hello.hello_spring.repository;

import com.hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  // 저장소에 저장
    /* Optional : null을 처리하는 기법 중 하나. */
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);

    List<Member> findAll();
}
