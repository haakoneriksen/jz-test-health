package no.priv.eriksen.javazone.healthcheck;

import no.priv.eriksen.javazone.FoodInspectionStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodInspectionStoreHealthCheck implements HealthCheck {

    private final FoodInspectionStore foodInspectionStore;

    @Autowired
    public FoodInspectionStoreHealthCheck(FoodInspectionStore foodInspectionStore) {
        this.foodInspectionStore = foodInspectionStore;
    }

    @Override
    public Result getResult() {
        if (foodInspectionStore.size() > 0) {
            return new Result(Result.Value.OK);
        } else {
            return new Result(Result.Value.FAIL, "No entries in store");
        }
    }

}
