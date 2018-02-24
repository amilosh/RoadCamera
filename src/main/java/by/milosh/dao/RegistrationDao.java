package by.milosh.dao;

import by.milosh.model.Registration;

import java.util.List;

public interface RegistrationDao {
    void save(Registration registration);

    List<Registration> findAll();

    List<Registration> findByCarNumber(String carNumber);

    long countOfRegistrations();
}
