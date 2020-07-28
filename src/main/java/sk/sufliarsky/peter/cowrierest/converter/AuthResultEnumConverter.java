package sk.sufliarsky.peter.cowrierest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sk.sufliarsky.peter.cowrierest.enums.AuthResultEnum;

@Component
public class AuthResultEnumConverter implements Converter<String, AuthResultEnum> {

    @Override
    public AuthResultEnum convert(String value) {
        return AuthResultEnum.valueOf(value.toUpperCase());
    }
}
