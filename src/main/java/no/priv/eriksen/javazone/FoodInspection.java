package no.priv.eriksen.javazone;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE)
class FoodInspection {

    String name;
    int orgId;
    String address;
    int postCode;
    String postName;
    int inspectionResult;

    FoodInspection(String name, int orgId, String address, int postCode, String postName, int inspectionResult) {
        this.name = name;
        this.orgId = orgId;
        this.address = address;
        this.postCode = postCode;
        this.postName = postName;
        this.inspectionResult = inspectionResult;
    }
}
