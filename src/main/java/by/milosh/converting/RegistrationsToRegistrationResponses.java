package by.milosh.converting;

import by.milosh.controller.response.RegistrationResponse;
import by.milosh.model.Registration;

import java.util.List;

public interface RegistrationsToRegistrationResponses extends Convert<List<Registration>, List<RegistrationResponse>> {
}
