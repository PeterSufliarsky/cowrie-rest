package sk.sufliarsky.peter.cowrierest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sk.sufliarsky.peter.cowrierest.enums.ActivityEnum;

@Component
public class ActivityEnumConverter implements Converter<String, ActivityEnum> {

    @Override
    public ActivityEnum convert(String value) {
        return ActivityEnum.valueOf(value.toUpperCase());
    }
}
