package com.brick.boot.spring.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) // 테스트를진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.
// 여기서는 SpringRunner라는 스프링 실행자를 사용합니다.
// 즉, 스프링 부트 테스트와 JUnit사이에 연결자 역할을 합니다.
@WebMvcTest(controllers =  HelloController.class)
// 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 에노테이션
// 선언할 경우 @Controller, @ControllerAdive등을 사용할 수 있음.
// 단, @Service, @Component, @Reposity등은 사용 불가
// 여기서는 컨트롤러만 사용하기 때문에 선언
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;
    // 웹 APi테스트 할 때 사용
    // 스프링 MVC 테스트의 시작점
    // 이 클래스를 통해 GET,POST등에 대한 API테스트를 할 수 있음

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello주소로 HTTP GET요청이 들어옴
                // 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언 가능
                .andExpect(status().isOk())
                // mvc.perfom의 결과를 검증
                // HTTP Header의 Status를 검증함
                // 우리가 흔히 알고 있는 200,404,500등의 상태를 검증함
                // 여기선 OK즉, 200인지 아닌지 검증함
                .andExpect(content().string(hello));
                // mvc.perfome의 결과를 검증
                // 응답 본문의 내용을 검증
                // Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증함

    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}