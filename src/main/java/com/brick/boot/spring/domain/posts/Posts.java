package com.brick.boot.spring.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter            // 롬복
@NoArgsConstructor // 롬복
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auti_increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
