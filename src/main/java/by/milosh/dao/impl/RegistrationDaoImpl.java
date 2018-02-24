package by.milosh.dao.impl;

import by.milosh.dao.RegistrationDao;
import by.milosh.model.Registration;
import by.milosh.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationDaoImpl implements RegistrationDao {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public void save(Registration registration) {
        registrationRepository.save(registration);
    }

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public List<Registration> findByCarNumber(String carNumber) {
        return registrationRepository.findByCarNumber(carNumber);
    }

    @Override
    public long countOfRegistrations() {
        return registrationRepository.count();
    }
}
