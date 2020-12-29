package com.brick.book.springboot.domain.posts;

import java.time.LocalDateTime;
import java.time.Month;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정없이  사용할 경우 H2로 자동 연결
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() throws Exception {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // 테이블 posts에 insert/update쿼리를 실행한다
                                            // id 값이 있다면 update 없다면 insert
                .title(title)
                .content(content)
                .author("tlfanfvk@gamil.com")
                .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.of(2020, Month.DECEMBER, 29, 0, 0, 0);
        postsRepository.save(Posts.builder()
            .title("title")
            .content("content")
            .author("author")
            .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createDate=" + posts.getCreateDate() + ", modifiedDate=" + posts.getModifyDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifyDate()).isAfter(now);
    }
}