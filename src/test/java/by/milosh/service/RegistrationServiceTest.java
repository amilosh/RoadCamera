package by.milosh.service;

import by.milosh.controller.response.CountResponse;
import by.milosh.controller.response.RegistrationResponse;
import by.milosh.model.Registration;
import by.milosh.repository.RegistrationRepository;
import by.milosh.service.exception.ServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationServiceTest {
    private static final String CAR_NUMBER = "1234 AB-7";
    Registration registration = new Registration();

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationService registrationService;

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
        try {
            RegistrationResponse registrationResponse = registrationService.save(registration);
            assertThat(CAR_NUMBER, equalTo(registrationResponse.getCarNumber()));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllTest() {
        try {
            List<RegistrationResponse> registrations = registrationService.findAll();
            assertThat(registrations.size(), equalTo(1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByCarNumberTest() {
        try {
            List<RegistrationResponse> registrations = registrationService.findByCarNumber(CAR_NUMBER);
            assertThat(CAR_NUMBER, equalTo(registrations.get(0).getCarNumber()));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countOfRegistrationsTest() {
        try {
            CountResponse countOfRegistrations = registrationService.countOfRegistrations();
            assertThat(countOfRegistrations.getCount(), equalTo(1L));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
