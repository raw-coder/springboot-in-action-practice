package readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class ReadingListApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(ReadingListApplication.class, args);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // login 경로를 login template 으로 mapping
    registry.addViewController("/login").setViewName("login");
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    // Reader 타입 객체가 컨트롤러의 매개변수로 존재할때 처리할 Resolver 설정
    resolvers.add(new ReaderHandlerMethodArgumentResolver());
  }
}
