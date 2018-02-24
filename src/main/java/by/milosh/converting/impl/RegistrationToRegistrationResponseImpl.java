package by.milosh.converting.impl;

import by.milosh.controller.response.RegistrationResponse;
import by.milosh.converting.DateToString;
import by.milosh.converting.RegistrationToRegistrationResponse;
import by.milosh.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationToRegistrationResponseImpl implements RegistrationToRegistrationResponse {
    @Autowired
    DateToString dateToString;

    @Override
    public RegistrationResponse execute(Registration registration) {
        String date = dateToString.execute(registration.getTimeStamp());
        return RegistrationResponse.builder()
                .id(registration.getId())
                .timeStamp(date)
                .carNumber(registration.getCarNumber())
                .build();
    }
}
