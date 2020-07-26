package me.whiteship.demospring51;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    // Advice와 Pointcut을 정의해야 합니다.

    // execution : 포인트 컷 표현식인데 이 표현식을 사용하여 어디에 적용할지 정의할 수 있습니다.
    // me.whiteship 패키지와 하위 패키지에 있는 EventService의 모든 메서드에 advice를 적용 합니다.
    @Around("@annotation(PerLogging)")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.currentTimeMillis();
        // ProceedingJoinPoint의 proceed() 메서드로 타겟 메서드를 호출 하고 그 결과 값을 전달 받습니다.
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;

    }

}
