package com.brick.book.springboot.config;


import com.brick.book.springboot.config.auth.LoginUserArgumentResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * LoginUserArgumentResolver가 스프링에서 인식될 수 있도록
 */
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final LoginUserArgumentResolver loginUserArgumentResolver;

  // HandlerMethodArgumentResolver는 항상 WebMvcConfigurer의 addArgumentResolvers를 통해 추가해야한다.
  // 다른 Handler-HandlerMethodArgumentResolver가 필요한 경우 같은 방식으로 추가.
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(loginUserArgumentResolver);
  }
}
