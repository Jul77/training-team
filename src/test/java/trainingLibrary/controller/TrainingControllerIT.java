package trainingLibrary.controller;

import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TrainingControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateTrainings() throws Exception {
        mockMvc.perform(post("/trainings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createTrainingJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.createTrainingId").value("1"));
    }

    @Test
    void shouldGetById() throws Exception {
        mockMvc.perform(post("/trainings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createTrainingJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.createTrainingId").value("1"));

        mockMvc.perform(get("/trainings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createTrainingJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainingDTO.id").value("1"))
                .andExpect(jsonPath("$.trainingDTO.trainingChoice").value("test trainingChoice"))
                .andExpect(jsonPath("$.trainingDTO.trainer").value("test trainer"));
    }

    private String createTrainingJSON() throws JSONException {
        return new JSONObject()
                .put("trainingChoice", "test trainingChoice")
                .put("trainer", "test trainer")
                .toString();
    }

}