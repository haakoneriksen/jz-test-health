package no.priv.eriksen.javazone;

import java.util.ArrayList;
import java.util.List;

class StubFoodInspectionStore implements FoodInspectionStore {

    @Override
    public List<FoodInspection> getByOrgId(int orgId) {
        return getFoodInspections();
    }

    @Override
    public List<FoodInspection> getByPostCode(int postCode) {
        return getFoodInspections();
    }

    private List<FoodInspection> getFoodInspections() {
        FoodInspection foodInspection = new FoodInspection("Rest Aurant", 123456, "Gateveien 5", 1234, "Sted", 2);
        List<FoodInspection> foodInspections = new ArrayList<>();
        foodInspections.add(foodInspection);
        return foodInspections;
    }

    @Override
    public int size() {
        return 1;
    }

}
