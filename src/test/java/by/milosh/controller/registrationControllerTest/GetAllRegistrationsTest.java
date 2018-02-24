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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetAllRegistrationsTest {
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
    public void getAllRegistrations() {
        ResponseEntity<List<RegistrationResponse>> response =
                restTemplate.exchange("/registrations",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<RegistrationResponse>>() {
                        }
                );
        List<RegistrationResponse> registrations = response.getBody();
        assertNotNull(registrations);
        assertThat(CAR_NUMBER, equalTo(registrations.get(0).getCarNumber()));
    }
}
