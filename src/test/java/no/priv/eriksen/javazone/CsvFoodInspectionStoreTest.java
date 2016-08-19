package no.priv.eriksen.javazone;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CsvFoodInspectionStoreTest {

    private FoodInspectionStore foodInspectionStore;

    @Before
    public void setUp() throws Exception {
        foodInspectionStore = new CsvFoodInspectionStore();
    }

    @Test
    public void canGetInspectionByOrgId() throws Exception {
        List<FoodInspection> foodInspections = foodInspectionStore.getByOrgId(985129576);
        assertTrue(foodInspections.get(0).orgId == 985129576);
        assertTrue(foodInspections.get(0).postCode == 9950);
        assertTrue(foodInspections.get(0).name.equals("Abc Thai AS"));
    }

    @Test
    public void catGetInspectionByPostCode() throws Exception {
        List<FoodInspection> foodInspections = foodInspectionStore.getByPostCode(9950);
        assertTrue(foodInspections.get(0).orgId == 985129576);
        assertTrue(foodInspections.get(0).postCode == 9950);
        assertTrue(foodInspections.size() >= 1);
    }

}