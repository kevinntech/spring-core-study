package me.whiteship.demospring51;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // 파라미터로 전달되는 클래스 타입이 Event인지 확인
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 전달된 객체의 필드(title)이 비어 있거나 공백일 경우, errors에 에러 코드 또는 디폴트 메시지를 추가한다.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "Empty title is now allowed.");
    }
}
