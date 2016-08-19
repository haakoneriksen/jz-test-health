package no.priv.eriksen.javazone;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tilsyn")
class FoodInspectionController {

    private final FoodInspectionStore foodInspectionStore;

    FoodInspectionController() throws IOException {
        foodInspectionStore = new CsvFoodInspectionStore();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/orgid/{id}")
    List<FoodInspection> getInspectionByOrgId(@PathVariable(value = "id") Integer orgid) {
        return foodInspectionStore.getByOrgId(orgid);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/postnr/{nr}")
    List<FoodInspection> getInspectionByPostcode(@PathVariable(value = "nr") Integer postCode) {
        return foodInspectionStore.getByPostCode(postCode);
    }

}
