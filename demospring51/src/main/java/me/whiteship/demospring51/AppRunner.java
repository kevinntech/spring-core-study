package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(validator.getClass());

        // 검증 대상인 Event 객체 생성
        Event event = new Event();
        event.setLimit(-1);   // limit에 에러 발생을 위해 -1을 설정
        event.setEmail("aa"); // email에 email이 아닌 값으로 설정

        Errors errors = new BeanPropertyBindingResult(event, "event");

        validator.validate(event, errors);

        System.out.println(errors.hasErrors());

        errors.getAllErrors().forEach( e -> {
            System.out.println("===== error Code =====");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
    }
}

