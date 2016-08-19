package no.priv.eriksen.javazone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

class CsvFoodInspectionStore implements FoodInspectionStore {

    private final List<FoodInspection> foodInspections = new ArrayList<>();

    CsvFoodInspectionStore() throws IOException {
        Reader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("tilsyn.csv")));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';'));
        List<CSVRecord> records = parser.getRecords();
        CSVRecord headerRecord = records.remove(0);
        Map<String, Integer> headers = parseHeaderRecord(headerRecord);
        for (CSVRecord record : records) {
            String name = record.get(headers.get("navn"));

            final String orgNrStr = record.get(headers.get("orgnummer")).trim(); // trim because trailing whitespace in some records
            Integer orgId = 0;
            if (orgNrStr.matches("[0-9]{9}")) {
                orgId = Integer.valueOf(orgNrStr);
            }

            String address = record.get(headers.get("adrlinje1"));

            final String postCodeStr = record.get(headers.get("postnr")).trim();
            Integer postCode = 0;
            if (postCodeStr.matches("[0-9]{4}")) {
                postCode = Integer.valueOf(postCodeStr);
            }

            String postName = record.get(headers.get("poststed"));
            Integer inspectionResult = Integer.valueOf(record.get(headers.get("total_karakter")));

            foodInspections.add(new FoodInspection(name, orgId, address, postCode, postName, inspectionResult));
        }
    }

    // parse header manually because parser.getHeaderMap() returned null
    private Map<String, Integer> parseHeaderRecord(CSVRecord headerRecord) {
        Map<String, Integer> headers = new HashMap<>();
        for (int i = 0; i < headerRecord.size(); i++) {
            headers.put(headerRecord.get(i), i);
        }
        return headers;
    }

    @Override
    public List<FoodInspection> getByOrgId(int orgId) {
        return foodInspections.stream()
                .filter(inspection -> inspection.orgId == orgId)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodInspection> getByPostCode(int postCode) {
        return foodInspections.stream()
                .filter(inspection -> inspection.postCode == postCode)
                .collect(Collectors.toList());
    }

}
