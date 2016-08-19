package no.priv.eriksen.javazone;

import java.util.List;

public interface FoodInspectionStore {

    List<FoodInspection> getByOrgId(int orgId);

    List<FoodInspection> getByPostCode(int postCode);

    int size();

}
