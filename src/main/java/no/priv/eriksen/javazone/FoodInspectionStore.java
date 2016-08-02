package no.priv.eriksen.javazone;

import java.util.List;

interface FoodInspectionStore {

    List<Inspection> getByOrgId(int orgId);

    List<Inspection> getByPostCode(int postCode);

}
