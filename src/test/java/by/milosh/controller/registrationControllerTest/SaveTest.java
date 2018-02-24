package by.milosh.controller.registrationControllerTest;

import by.milosh.controller.response.RegistrationResponse;
import by.milosh.model.Registration;
import by.milosh.repository.RegistrationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaveTest {
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
    public void save() {
        Registration registration = new Registration();
        registration.setCarNumber(CAR_NUMBER);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Registration> request = new HttpEntity<>(registration, header);

        ResponseEntity<RegistrationResponse> registrationResponse = restTemplate.postForEntity("/registrations", request, RegistrationResponse.class);

        assertThat(registrationResponse.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(registrationResponse.getBody().getCarNumber(), is(CAR_NUMBER));
    }
}
