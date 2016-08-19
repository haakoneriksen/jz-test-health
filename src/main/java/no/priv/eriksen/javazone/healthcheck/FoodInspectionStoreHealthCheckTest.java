package no.priv.eriksen.javazone.healthcheck;

import no.priv.eriksen.javazone.FoodInspectionStore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static junit.framework.TestCase.assertTrue;

@Component
public class FoodInspectionStoreHealthCheckTest implements HealthCheck {

    @Autowired
    private FoodInspectionStore foodInspectionStore;

    public FoodInspectionStoreHealthCheckTest() {
    }

    @Override
    public Result getResult() {
        if (foodInspectionStore.size() > 0) {
            return new Result(Result.Value.OK);
        } else {
            return new Result(Result.Value.FAIL, "No entries in store");
        }
    }

    @Test
    public void hasMoreThanOneEntry() {
        assertTrue(foodInspectionStore.size() > 1);
    }

}
