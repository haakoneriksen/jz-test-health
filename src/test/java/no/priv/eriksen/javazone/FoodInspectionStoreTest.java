package no.priv.eriksen.javazone;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodInspectionStoreTest {

    private FoodInspectionStore foodInspectionStore;

    @Before
    public void setUp() throws Exception {
        foodInspectionStore = new StubFoodInspectionStore();
    }

    @Test
    public void canGetInspectionByOrgId() throws Exception {
        List<Inspection> inspections = foodInspectionStore.getByOrgId(123456);
        assertTrue(inspections.get(0).orgId == 123456);
        assertTrue(inspections.get(0).postCode == 1234);
        assertTrue(inspections.get(0).name.equals("Rest Aurant"));
    }

    @Test
    public void catGetInspectionByPostCode() throws Exception {
        List<Inspection> inspections = foodInspectionStore.getByPostCode(1234);
        assertTrue(inspections.get(0).orgId == 123456);
        assertTrue(inspections.get(0).postCode == 1234);
        assertTrue(inspections.size() >= 1);
    }

}