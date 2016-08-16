package no.priv.eriksen.javazone;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FoodInspectionControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new FoodInspectionController()).build();
    }

    @Test
    public void getTilsynByPostCode() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tilsyn/postnr/9950").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value(equalTo("Abc Thai AS")))
                .andExpect(jsonPath("$.[0].orgId").value(equalTo(985129576)))
                .andExpect(jsonPath("$.[0].address").value(equalTo("Christian IV gate 3")))
                .andExpect(jsonPath("$.[0].postCode").value(equalTo(9950)))
                .andExpect(jsonPath("$.[0].postName").value(equalTo("VARDØ")))
                .andExpect(jsonPath("$.[0].inspectionResult").value(equalTo(1)));
    }

}