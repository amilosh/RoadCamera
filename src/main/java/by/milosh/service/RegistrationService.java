package by.milosh.service;

import by.milosh.controller.response.CountResponse;
import by.milosh.controller.response.RegistrationResponse;
import by.milosh.model.Registration;
import by.milosh.service.exception.ServiceException;

import java.util.List;

public interface RegistrationService {
    RegistrationResponse save(Registration registration) throws ServiceException;

    List<RegistrationResponse> findAll() throws ServiceException;

    List<RegistrationResponse> findByCarNumber(String carNumber) throws ServiceException;

    CountResponse countOfRegistrations() throws ServiceException;
}
