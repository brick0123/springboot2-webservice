package com.brick.book.springboot.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;
        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        // assertThat : assertj라는 테스트 검증 ㄹ이브러리의 검증 메소드
        // 검증하고 싶은 대상을 메소드 인자로 받는다
        // isEqualTo : assertj의 동등 비교 메소드
        // asserThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
        assertThat(dto.getAmount()).isEqualTo(amount);
     
        // Junit의 asserThat이 아닌 assertj의 asserThat을 사용하는 이유
        
        // Junit의 asserThat을 쓰게 되면 is()와 같이 CoreMatchers라이버르리가 필요함
        // 자동 완성이 좀 더확실하게 지원된다
    }

}