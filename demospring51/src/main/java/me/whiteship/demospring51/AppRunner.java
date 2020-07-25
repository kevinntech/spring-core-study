package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ConversionService conversionService;    // 빈을 주입 받음

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(conversionService.getClass().toString());
    }
}
