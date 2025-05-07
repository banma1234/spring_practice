package com.hello.hello_spring.repository;

import com.hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 인터페이스 이름 규칙을 해석해서 알잘딱깔센으로 기능 개발 해준다.
    // findByName => select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
