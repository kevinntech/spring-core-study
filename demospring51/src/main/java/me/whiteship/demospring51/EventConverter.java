package me.whiteship.demospring51;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class EventConverter {

    public static class StringToEventConverter implements Converter<String, Event>{
        @Override
        public Event convert(String source) {
            return new Event(Integer.parseInt(source));
        }
    }

    public static class EventToStringConverter implements Converter<Event, String>{
        @Override
        public String convert(Event source) {
            return source.getId().toString();
        }
    }
}
