package com.brick.book.springboot.web;

import com.brick.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
// 테스트를 진행할 때 Junit에 내장된 실행자 외에 다른 실행자를 실행시킨다
// 여기서는 SpringRunner라는 스프링 실행자를 사용함
// 스프링 부트 테스트와 JUnit 사이에 연결자 역할을함
@WebMvcTest(controllers = HelloController.class,
    excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
    })
// 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
// 선언할 경우 @Controller, @ControllerAdvice등을 사용할 수 있음
// 단 @Service, @Component, @Repository등은 사용할 수 없음
// 여기서는 컨트롤러만 사용하기 떄문에 선언
// WebMvcTest는 JPA기능이 작동하지 않음
public class HelloControllerTest {

  @Autowired
  private MockMvc mvc;
  // 웹 API를 테스트할 때 사용함
  // 스프링 MVC 태스트의 시작점
  // 이 클래스르 통해 HTTP GET,POST등에 대한 API를 테스트를 할 수 있음

  @Test
  @WithMockUser(roles = "USER")
  public void hello가_리턴된다() throws Exception {
    String hello = "hello";

    mvc.perform(get("/hello"))
        // MockMvc를 통해 /hello 주소로 HTTP GET 요청을함
        .andExpect(status().isOk())
        // mvc.perform의 결과를 검증한다
        // HTTP header의 Status를 검증
        // 여기선 OK 즉 200인지 아닌지를 검장함
        .andExpect(content().string(hello));
    // mvc.perform의 결과를 검증함
    // 응답 본문의 내용을 검증

  }

  @Test
  @WithMockUser(roles = "USER")
  public void helloDto가_리턴된다() throws Exception {
    String name = "hello";
    int amount = 1000;

    mvc.perform(
        get("/hello/dto")
            .param("name", name)
            .param("amount", String.valueOf(amount)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is(name)))
        .andExpect(jsonPath("$.amount", is(amount)));
    // jsonPath : JSON 응당 값을 필드별로 검증할 수 있는 메소드
    // $를 기준으로 필드명을 명시

  }

}