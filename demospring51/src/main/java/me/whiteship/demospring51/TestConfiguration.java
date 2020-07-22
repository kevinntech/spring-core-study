package me.whiteship.demospring51;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfiguration {

    // 해당 빈 설정 파일은 test 설정일 때만 사용되는 빈 설정 파일이 됩니다.

    @Bean
    @Profile("test")
    public BookRepository bookRepository(){
        return new TestBookRepository();
    }
}
