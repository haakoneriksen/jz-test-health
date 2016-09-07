package no.priv.eriksen.javazone.healthcheck;

import java.util.Optional;

public interface HealthCheck {

   class Result {
        public enum Value {OK, FAIL}

        final Value value;
        Optional<String> failReason = Optional.empty();

        Result(Value value) {
            this.value = value;
        }

        Result(Value value, String failReason) {
            this.value = value;
            this.failReason = Optional.of(failReason);
        }

        public boolean isOK() {
            return value.equals(Value.OK);
        }

    }

    Result getResult();

}
