package trainingLibrary.controller;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class},
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
class TrainingControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DatabaseSetup(value = "classpath:dbunit/create-trainings-dataset.xml")
    @ExpectedDatabase(value = "classpath:dbunit/create-trainings-expected.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @DatabaseTearDown(value = "classpath:dbunit/create-trainings-teardown.xml", type = DatabaseOperation.DELETE_ALL)
    void shouldCreateTrainings() throws Exception {
        mockMvc.perform(get("/trainings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createTrainingJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.createdTrainingId").value("1"));

    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-trainings-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-trainings-dataset.xml")
    void shouldGetById() throws Exception {

        mockMvc.perform(get("/trainings/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createTrainingJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainings.id").value("2"))
                .andExpect(jsonPath("$.trainings.training_choice").value("test training choice"))
                .andExpect(jsonPath("$.trainings.trainer").value("test trainer"));
    }

    private String createTrainingJSON() throws JSONException {
        return new JSONObject()
                .put("training_choice", "test training choice")
                .put("trainer", "test trainer")
                .put("user_id",3)
                .toString();
    }

}