package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

// AppRunner의 코드 : [그림] Client
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    EventService eventService; // 클라이언트는 @Autowired로 EventService 타입의 빈을 주입 받지만
                               // 내가 @Primary로 설정 해둔 ProxySimpleEventService 빈을 주입 받습니다.

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();
    }
}
