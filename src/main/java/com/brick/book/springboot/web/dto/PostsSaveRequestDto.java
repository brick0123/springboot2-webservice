package com.brick.book.springboot.web.dto;

import com.brick.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    // 절대로 Dto클래스를 REquest/Response클래스로 사용해서는 안 된다.
    // Entity 클래스는 db와 맞닿는 핵심 클래스
    // Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경이 된다.
    // 화면변경은 아주 사소한 기능인데, 이를 위해 테이블과 연결된 Entity 클래스를 변경하는 것은
    // 너무 큰 변경이다. 수 많은 서비스 클래스나 비즈니스 로직들이 Entity클래스 기준으로 동작합니다.
    // Entity클래스가 변경이 되면 여러 클래스에 영향을 끼치지만
    // Request와 Response용 Dto는 View를 위핸 클래스라 정말 자주 변경이 필요하다
    // Veiw Layer와 Db Layer의 역할을 철저하게 분리하는게좋다.
}
