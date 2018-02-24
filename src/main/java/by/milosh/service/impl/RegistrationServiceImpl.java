package by.milosh.service.impl;

import by.milosh.controller.response.CountResponse;
import by.milosh.controller.response.RegistrationResponse;
import by.milosh.converting.RegistrationToRegistrationResponse;
import by.milosh.converting.RegistrationsToRegistrationResponses;
import by.milosh.dao.RegistrationDao;
import by.milosh.model.Registration;
import by.milosh.service.RegistrationService;
import by.milosh.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private static Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private RegistrationDao registrationDao;

    @Autowired
    private RegistrationToRegistrationResponse registrationToRegistrationResponse;

    @Autowired
    private RegistrationsToRegistrationResponses registrationsToRegistrationResponses;

    @Override
    public RegistrationResponse save(Registration registration) throws ServiceException {
        try {
            registrationDao.save(registration);
            return registrationToRegistrationResponse.execute(registration);
        } catch (Exception e) {
            logger.error("Could not save the registration: " + e);
            throw new ServiceException();
        }
    }

    @Override
    public List<RegistrationResponse> findAll() throws ServiceException {
        try {
            List<Registration> registrations = registrationDao.findAll();
            return registrationsToRegistrationResponses.execute(registrations);
        } catch (Exception e) {
            logger.error("Could not find all registrations: " + e);
            throw new ServiceException();
        }
    }

    @Override
    public List<RegistrationResponse> findByCarNumber(String carNumber) throws ServiceException {
        try {
            List<Registration> registrations = registrationDao.findByCarNumber(carNumber);
            return registrationsToRegistrationResponses.execute(registrations);
        } catch (Exception e) {
            logger.error("Could not find all registrations by car number: " + e);
            throw new ServiceException();
        }
    }

    @Override
    public CountResponse countOfRegistrations() throws ServiceException {
        try {
            long count = registrationDao.countOfRegistrations();
            return new CountResponse(count);
        } catch (Exception e) {
            logger.error("Could not get count of registrations: " + e);
            throw new ServiceException();
        }
    }
}
