package com.mayank.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mayank.app.model.Appointment;
import com.mayank.app.model.Prescription;
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

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({DoctorController.class})
@ActiveProfiles(value = "test")
public class DoctorContollerWebTest {
    @Autowired
    private MockMvc mockMvc;

    @Value("${doctor.create.url}")
    String create_url;
    @Value("${doctor.read.url}")
    String read_url;


    @Test
    public void test_createStudent() throws Exception {
        Appointment appointment=new Appointment();
        appointment.setDoctorName("X");
        appointment.setAppointmentId("1");
        appointment.setDate("today");
        appointment.setPrescription(new Prescription());
        appointment.setPatientName("NONE");

        ResultActions resultActions=mockMvc.perform(get(read_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(appointment.getDoctorName())).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Appointment result = g.fromJson(result_string, Appointment.class);
        assertEquals("X",result.getDoctorName());

    }

    @Test
    public void test_readeStudent() throws Exception {
        Appointment appointment=new Appointment();
        appointment.setDoctorName("X");
        appointment.setAppointmentId("1");
        appointment.setDate("today");
        appointment.setPrescription(new Prescription());
        appointment.setPatientName("NONE");

        ResultActions resultActions_create=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(appointment)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get("/read").param("name","stud1").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Appointment result = g.fromJson(result_string, Appointment.class);
        assertEquals("X",result.getDoctorName());

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
