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

@Component
public class AppRunner implements ApplicationRunner {

    @Value("#{1+1}")
    int value;

    @Value("#{'hello ' + 'world'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("hello")
    String hello;

    @Value("${my.value}")
    int myValue;

    @Value("#{${my.value} eq 100 }")
    boolean ismyValue100;

    @Value("#{'spring'}")
    String spring;

    @Value("#{sample.data}")
    int sampleData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("================");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(myValue);
        System.out.println(ismyValue100);
        System.out.println(spring);
        System.out.println(sampleData);

        ExpressionParser parse = new SpelExpressionParser();
        Expression expression = parse.parseExpression("2 + 100");
        Integer value = expression.getValue(Integer.class);
        System.out.println(value);
    }
}
