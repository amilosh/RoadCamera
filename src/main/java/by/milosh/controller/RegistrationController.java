package by.milosh.controller;

import by.milosh.controller.exception.RegistrationException;
import by.milosh.controller.response.CountResponse;
import by.milosh.controller.response.RegistrationResponse;
import by.milosh.model.Registration;
import by.milosh.service.RegistrationService;
import by.milosh.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/registrations", produces = "application/json")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<RegistrationResponse> save(@RequestBody Registration registration) throws RegistrationException {
        try {
            return new ResponseEntity<RegistrationResponse>(
                    registrationService.save(registration),
                    HttpStatus.OK);
        } catch (ServiceException e) {
            throw new RegistrationException("Could not save the registration.");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RegistrationResponse>> getAllRegistrations() throws RegistrationException {
        try {
            List<RegistrationResponse> registrations = registrationService.findAll();
            if (registrations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<List<RegistrationResponse>>(
                        registrations,
                        HttpStatus.OK);
            }
        } catch (ServiceException e) {
            throw new RegistrationException("Could not find all registrations.");
        }
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public ResponseEntity<List<RegistrationResponse>> getRegistrationsByNumber(@PathVariable("number") String carNumber) throws RegistrationException {
        try {
            List<RegistrationResponse> registrations = registrationService.findByCarNumber(carNumber);
            if (registrations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<List<RegistrationResponse>>(
                        registrations,
                        HttpStatus.OK);
            }
        } catch (ServiceException e) {
            throw new RegistrationException("Could not find all registrations by car number.");
        }
    }

    @RequestMapping(value = "/stats/count", method = RequestMethod.GET)
    public ResponseEntity<CountResponse> countOfRegistrations() throws RegistrationException {
        try {
            return new ResponseEntity<CountResponse>(
                    registrationService.countOfRegistrations(),
                    HttpStatus.OK);
        } catch (ServiceException e) {
            throw new RegistrationException("Could not get count of registrations.");
        }
    }
}
