package by.milosh.controller.registrationControllerTest;

import by.milosh.controller.response.CountResponse;
import by.milosh.model.Registration;
import by.milosh.repository.RegistrationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountOfRegistrationsTest {
    private static final String CAR_NUMBER = "1234 AB-7";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Before
    public void setup() {
        Registration registration = new Registration();
        registration.setCarNumber(CAR_NUMBER);
        registrationRepository.save(registration);
    }

    @Test
    public void countOfRegistrations() {
        ResponseEntity<CountResponse> response = restTemplate.getForEntity("/registrations/stats/count", CountResponse.class);
        assertThat(response.getBody().getCount(), is(1L));
    }
}
