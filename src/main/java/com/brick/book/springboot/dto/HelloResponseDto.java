package com.brick.book.springboot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
// 선언된 final 필드가 포함된 생성자를 생성해줌
// final이 없는 필드는 포함 x
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
