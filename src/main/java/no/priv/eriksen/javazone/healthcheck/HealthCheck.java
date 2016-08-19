package no.priv.eriksen.javazone.healthcheck;

import java.util.Optional;

interface HealthCheck {

    class Result {
        enum Value {OK, FAIL}

        final Value value;
        Optional<String> failReason = Optional.empty();

        Result(Value value) {
            this.value = value;
        }

        Result(Value value, String failReason) {
            this.value = value;
            this.failReason = Optional.of(failReason);
        }

    }

    Result getResult();

}
