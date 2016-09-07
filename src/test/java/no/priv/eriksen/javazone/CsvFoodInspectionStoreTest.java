package no.priv.eriksen.javazone;

import java.util.List;

import no.priv.eriksen.javazone.healthcheck.FoodInspectionStoreHealthCheck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CsvFoodInspectionStoreTest {

    private FoodInspectionStore foodInspectionStore;
    private FoodInspectionStoreHealthCheck healthCheck;


    @Before
    public void setUp() throws Exception {
        foodInspectionStore = new CsvFoodInspectionStore();
        healthCheck = new FoodInspectionStoreHealthCheck(foodInspectionStore);
    }

    @Test
    public void canGetInspectionByOrgId() throws Exception {
        List<FoodInspection> foodInspections = foodInspectionStore.getByOrgId(985129576);
        assertTrue(healthCheck.getResult().isOK());

        assertTrue(foodInspections.get(0).orgId == 985129576);
        assertTrue(foodInspections.get(0).postCode == 9950);
        assertTrue(foodInspections.get(0).name.equals("Abc Thai AS"));
    }

    @Test
    public void canGetInspectionByPostCode() throws Exception {
        List<FoodInspection> foodInspections = foodInspectionStore.getByPostCode(9950);
        assertTrue(healthCheck.getResult().isOK());

        assertTrue(foodInspections.get(0).orgId == 985129576);
        assertTrue(foodInspections.get(0).postCode == 9950);
        assertTrue(foodInspections.size() >= 1);
    }

}