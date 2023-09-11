package cm.mayank.app.componenttest;


import cm.mayank.app.controller.PatientController;
import cm.mayank.app.model.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({PatientController.class})
@ActiveProfiles(value = "test")
public class PatientContollerWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${patient.create.url}")
    String create_url;
    @Value("${patient.read.url}")
    String read_url;
    @Value("${patient.update.url}")
    String update_url;
    @Value("${patient.delete.url}")
    String delete_url;

    @Test
    public void test_createPatient() throws Exception {
        Patient patient1=new Patient("P","X","M","A");
        ResultActions resultActions=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient1)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("P",result.getPatient());
        assertEquals("X",result.getId());
        assertEquals("M",result.getHospital());
        assertEquals("A",result.getDisease());
    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
