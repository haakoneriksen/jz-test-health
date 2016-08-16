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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
                .andExpect(content().string(equalTo("[{" +
                        "\"name\":\"Abc Thai AS\"," +
                        "\"orgId\":985129576," +
                        "\"address\":\"Christian IV gate 3\"," +
                        "\"postCode\":9950," +
                        "\"postName\":\"VARDØ\"," +
                        "\"inspectionResult\":1" +
                        "}]")));
    }

}