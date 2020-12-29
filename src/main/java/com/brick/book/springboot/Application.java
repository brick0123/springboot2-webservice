package com.brick.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean읽기와 생성을 모두 자동으로 설정됨
// 현재위치로부터 설정을 읽어오기 때문에 최상단에 위치해야함
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // 내장 WAS를 실행함. Jar파일로 실행하면 됨!
        // 꼭 스프링 부트에서 내장 WAS를 사용할 수 있는 것은 아니지만
        // 스프링 부트에서는 내장 WAS를 사용할 것을 권장함.
        // 외장 AWS를 사용하면 모든 서버는 WAS의 종류와 버전, 설정을 일치 시켜야 한다.
        // - 새로운 서버가 추가되면 모든 서버가 같은 WAS 환경을 구축해야함.
    }
}
