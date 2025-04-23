package com.hello.hello_spring.repository;

import com.hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 테스트케이스 종료 후 호출.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        // Optional로 감싸놔서 뒤에 get() 붙임
        Member result = repository.findById(member.getId()).get();
        
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setName("spring_1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring_2");
        repository.save(member2);

        Member result1 = repository.findByName("spring_1").get();
        Member result2 = repository.findByName("spring_2").get();

        assertThat(member1).isEqualTo(result1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring_1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring_2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
