package com.example.rest;

import com.example.ProcessesApplication;
import com.example.model.App;
import com.example.model.State;
import com.example.repo.AppRepo;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

/**
 * Created by internship on 14.09.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProcessesApplication.class)
@WebAppConfiguration
/**
 * Created by internship on 15.09.2016.
 */
public class AppControllerTest extends BaseControllerTest {
    private int calendar = 2;

    private int addHours(int hours) {
        return calendar = calendar + 2;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Autowired
    Gson gson;

    @Autowired
    private AppRepo repo;

    @Test
    public void update() throws Exception {
        App app1 = new App(123, "Skype", "Skype 123");
        App app2 = new App(1234, "Chrome", "Chrome 1234");

        System.out.println(LocalDate.now().toEpochDay());

        List<App> apps = new ArrayList<>();

        app1.getStates().add(new State(calendar, 0, true, calendar));
        app1.getStates().add(new State(0, 0, true, addHours(2)));
        app2.getStates().add(new State(0, addHours(1), true, calendar));

        apps.add(app1);
        apps.add(app2);

        System.out.println(gson.toJson(apps));

        mockMvc.perform(post("/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(apps))
                )
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
    }
}