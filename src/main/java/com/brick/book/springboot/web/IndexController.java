package com.brick.book.springboot.web;

import com.brick.book.springboot.config.auth.LoginUser;
import com.brick.book.springboot.config.auth.dto.SessionUser;
import com.brick.book.springboot.service.posts.PostsService;
import com.brick.book.springboot.web.dto.PostsResponseDto;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

  private final PostsService postsService;
  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model, @LoginUser SessionUser user) { // 서블릿 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
    model.addAttribute("posts", postsService.findAllDesc());

//    SessionUser user = (SessionUser) httpSession.getAttribute("user");

    // 압서 작성된 CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser 저장.
    // 로그인 성공시 httpSession.getAttibute("user")에서 값을 가져올 수 있음.

    if (user != null) {
      model.addAttribute("userName", user.getName());

    }
    return "index";
  }

  @GetMapping("/posts/save")
  public String postsSave() {
    return "posts-save";
  }

  @GetMapping("/posts/update/{id}")
  public String postsUpdate(@PathVariable Long id, Model model) {
    PostsResponseDto dto = postsService.findById(id);
    model.addAttribute("post", dto);

    return "posts-update";
  }
}
