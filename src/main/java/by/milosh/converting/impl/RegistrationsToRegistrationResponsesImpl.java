package by.milosh.converting.impl;

import by.milosh.controller.response.RegistrationResponse;
import by.milosh.converting.RegistrationToRegistrationResponse;
import by.milosh.converting.RegistrationsToRegistrationResponses;
import by.milosh.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegistrationsToRegistrationResponsesImpl implements RegistrationsToRegistrationResponses {
    @Autowired
    private RegistrationToRegistrationResponse registrationToRegistrationResponse;

    @Override
    public List<RegistrationResponse> execute(List<Registration> registrations) {
        List<RegistrationResponse> registrationResponses = new ArrayList<>();
        for (Registration registration : registrations) {
            RegistrationResponse registrationResponse = registrationToRegistrationResponse.execute(registration);
            registrationResponses.add(registrationResponse);
        }
        return registrationResponses;
    }
}
