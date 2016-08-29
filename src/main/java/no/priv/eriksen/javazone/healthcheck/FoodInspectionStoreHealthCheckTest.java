package no.priv.eriksen.javazone.healthcheck;

import java.io.IOException;

import no.priv.eriksen.javazone.CsvFoodInspectionStore;
import no.priv.eriksen.javazone.FoodInspectionStore;
import org.junit.Before;
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
        if (isNotEmpty()) {
            return new Result(Result.Value.OK);
        } else {
            return new Result(Result.Value.FAIL, "No entries in store");
        }
    }

    @Before
    public void before() throws IOException {
        if (foodInspectionStore == null) {
            foodInspectionStore = new CsvFoodInspectionStore();
        }
    }

    @Test
    public void testIsNotEmpty() {
        assertTrue(isNotEmpty());
    }

    private boolean isNotEmpty() {
        return foodInspectionStore.size() > 1;
    }

}
