package com.brick.boot.spring.web;

import com.brick.boot.spring.web.dto.HelloReponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON으로 반환하는 컨트롤러를 만들어줌
// @ResponseBody를 각 메소드마다 선언 던 것을 한 번에 사용할 수 있게 해줌
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloReponseDto helloDto(@RequestParam("name") String name, @RequestParam int amount) {
        return new HelloReponseDto(name, amount);
    }
}
