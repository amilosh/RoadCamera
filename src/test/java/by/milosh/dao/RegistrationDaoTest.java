package by.milosh.dao;

import by.milosh.model.Registration;
import by.milosh.repository.RegistrationRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationDaoTest {
    private static final String CAR_NUMBER = "1234 AB-7";
    Registration registration = new Registration();

    @Autowired
    private RegistrationRepository registrationRepository;

    @Before
    public void setup() {
        registration.setCarNumber(CAR_NUMBER);
        registrationRepository.save(registration);
    }

    @After
    public void after() {
        registrationRepository.delete(registration);
    }

    @Test
    public void saveTest() {
        List<Registration> registrations = registrationRepository.findByCarNumber(CAR_NUMBER);
        assertThat(CAR_NUMBER, equalTo(registrations.get(0).getCarNumber()));
    }

    @Test
    public void findAllTest() {
        List<Registration> registrations = registrationRepository.findAll();
        assertNotNull(registrations);
        assertThat(registrations.size(), equalTo(1));
    }

    @Test
    public void findByCarNumberTest() {
        List<Registration> registrations = registrationRepository.findByCarNumber(CAR_NUMBER);
        assertNotNull(registrations);
        assertThat(CAR_NUMBER, equalTo(registrations.get(0).getCarNumber()));
    }

    @Test
    public void countOfRegistrationsTest() {
        long count = registrationRepository.count();
        assertThat(count, equalTo(1L));
    }
}
