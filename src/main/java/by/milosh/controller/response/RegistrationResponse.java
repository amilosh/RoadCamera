package by.milosh.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponse {
    private Long id;
    private String timeStamp;
    private String carNumber;

    public static class RegistrationResponseBuilder {
        private RegistrationResponse registrationResponse = new RegistrationResponse();

        public RegistrationResponseBuilder id(Long id) {
            registrationResponse.id = id;
            return this;
        }

        public RegistrationResponseBuilder timeStamp(String timeStamp) {
            registrationResponse.timeStamp = timeStamp;
            return this;
        }

        public RegistrationResponseBuilder carNumber(String carNumber) {
            registrationResponse.carNumber = carNumber;
            return this;
        }

        public RegistrationResponse build() {
            return registrationResponse;
        }
    }

    public static RegistrationResponseBuilder builder() {
        return new RegistrationResponseBuilder();
    }
}
