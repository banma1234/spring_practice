package com.hello.hello_spring.controller;

import com.hello.hello_spring.domain.Member;
import com.hello.hello_spring.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    /* Autowired는 스프링 컨테이너에서 memberService 가져옴.
    * 근데 MemberService는 그냥 클래스라서 컨테이너 단에서 알 수 없음
    * 그래서 MemberService에 @Service 달아서 Spring bean에 "싱글톤"으로 등록하고 가져오는거임.
    * 레포지도 마찬가지로 @Repository 키워드 달면 Spring bean에 등록.
    * 싱글톤 등록이니 같은 Spring bean이면 모두 같은 인스턴스다.
    * 이러한 과정을 "의존관계 주입"이라 한다. 당연히 메인 메서드 있는 패키지 하위에서만 작동. */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // POST 액션 발생시 input의 name값이 파라미터 MemberForm의 setName()을 스프링이 호출해서 등록함.
    // 이걸 getName으로 꺼내 쓰는거.
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
