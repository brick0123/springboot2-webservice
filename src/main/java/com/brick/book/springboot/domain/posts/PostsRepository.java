package com.brick.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Mybatis에서 Dao라고 불리는 DB Layer 접근자
// JPA에선 Repository라고 부르며 인터페이스로 생성함.
// JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
// @Repository를 추가할 필요도 없음
// ** 주의 Entitiy클래스와 기본 Entity Repository는 함께 위치해야 된다.
// 둘은 아주 밀접한 관계이고, Entity클래스는기본 Repository없이는 제대로 역할 수행 불가
// 도메인 패키지에서 함께 관리
public interface PostsRepository  extends JpaRepository<Posts, Long> {
}
