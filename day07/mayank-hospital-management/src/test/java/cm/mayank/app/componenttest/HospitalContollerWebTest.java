package cm.mayank.app.componenttest;


import cm.mayank.app.controller.HospitalController;
import cm.mayank.app.model.Hospital;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class})
@ActiveProfiles(value = "test")
public class HospitalContollerWebTest {

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
    public void test_createHospital() throws Exception {
        Hospital hospital=new Hospital("P","X","M");
        ResultActions resultActions=mockMvc.perform(post("/save/hospital").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("P",result.getName());
        assertEquals("X",result.getId());
    }

    @Test
    public void test_getPatient() throws Exception {
        Hospital hospital=new Hospital("P","X","M");
        ResultActions resultActions_create=mockMvc.perform(post("/save/hospital").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get("/get/hospital/X").param("id","X").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("M",result.getAddress());

    }

    @Test
    public void test_updatePatient() throws Exception {
        Hospital hospital=new Hospital("P","X","M");
        ResultActions resultActions_create=mockMvc.perform(post("/save/hospital").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put("/update/hospital").param("id","X")
                .param("name","UPD").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("UPD",result.getName());

    }

    @Test
    public void test_deletePatient() throws Exception {
        Hospital hospital=new Hospital("P","X","M");
        ResultActions resultActions_create=mockMvc.perform(post("/save/hospital").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(delete("/delete/hospital/X").param("id","X")
                        .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
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
