package no.priv.eriksen.javazone;

import java.util.ArrayList;
import java.util.List;

class StubFoodInspectionStore implements FoodInspectionStore {

    @Override
    public List<Inspection> getByOrgId(int orgId) {
        return getInspections();
    }

    @Override
    public List<Inspection> getByPostCode(int postCode) {
        return getInspections();
    }

    private List<Inspection> getInspections() {
        Inspection inspection = new Inspection("Rest Aurant", 123456, "Gateveien 5", 1234, "Sted", 2);
        List<Inspection> inspectionList = new ArrayList<>();
        inspectionList.add(inspection);
        return inspectionList;
    }

}
