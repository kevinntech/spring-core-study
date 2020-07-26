package me.whiteship.demospring51;

import org.springframework.stereotype.Service;

// SimpleEventSerivce : [그림] Real Subject
@Service
public class SimpleEventSerivce implements EventService {

    @PerLogging
    @Override
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Created an event");
    }

    @PerLogging
    @Override
    public void publishEvent() {
        try {
            Thread.sleep(2000);            // 2초 취고
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Published an event"); // 메시지 출력
    }

    public void deleteEvent(){
        System.out.println("Delete an event");
    }
}
