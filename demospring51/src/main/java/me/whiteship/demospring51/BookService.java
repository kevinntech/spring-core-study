package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    // @Qualifier : 주입 받고자 하는 클래스가 @Repository 애노테이션이 있다면 소문자로 시작하는 클래스명을 전달함
    /* @Autowired
       @Qualifier("keesunBookRepository")
       BookRepository bookRepository; */

    @Autowired
    List<BookRepository> bookRepository;

    // 해당 메서드를 이용하여 bookRepository에 어떠한 빈이 주입 되었는지 알 수 있음
    public void printBookRepository(){
        this.bookRepository.forEach(System.out::println);
    }
}
