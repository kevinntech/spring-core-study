package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProxySimpleEventService implements EventService {

    @Autowired
    SimpleEventSerivce simpleEventSerivce; // Proxy는 Real Subject의 빈을 주입 받아 사용해야 합니다.
                                           // EventSerivce simpleEventSerivce;
                                           // 바로 위의 코드도 가능 합니다.
                                           // EventSerivce 타입으로 받지만 빈의 이름에 기반해서 SimpleEventSerivce를 주입 받아도 됩니다.
    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis(); // 흩어진 관심사
        simpleEventSerivce.createEvent(); // simpleEventSerivce에게 deligation(위임)해서 처리. 프록시가 하는 일은 전부 위임을 하는 것 입니다. 그리고 시간을 측정하는 기능을 두 개의 메서드에 추가합니다.
        System.out.println(System.currentTimeMillis() - begin); // 흩어진 관심사
    }

    @Override
    public void publishEvent() {
        long begin = System.currentTimeMillis(); // 흩어진 관심사
        simpleEventSerivce.publishEvent();
        System.out.println(System.currentTimeMillis() - begin); // 흩어진 관심사
    }

    @Override
    public void deleteEvent() {
        simpleEventSerivce.deleteEvent();

    }
}
