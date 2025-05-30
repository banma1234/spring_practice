package com.hello.hello_spring;

import com.hello.hello_spring.repository.JdbcTemplateMemberRepository;
import com.hello.hello_spring.repository.JpaMemberRepository;
import com.hello.hello_spring.repository.MemberRepository;
// import com.hello.hello_spring.repository.MemoryMemberRepository;
import com.hello.hello_spring.repository.JdbcMemberRepository;
import com.hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;

/* config 파일처럼 자바 코드로 Spring Bean 의존성 주입해줌.
 * 왜 @Component 한줄 딸깍 안하냐? 라고 하면 DI 생성자 주입이 권장되기 때문.
 * 다른 방법들을 쓰면(한줄 딸깍, setter 주입) 실행중에 동적으로 변할 수 있음.
 * 그리고 이게 정형화된 구조이기도 하니까.. 유지보수 면에서도 이게 좋다. */
@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    // JPA 엔티티 메니저
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
