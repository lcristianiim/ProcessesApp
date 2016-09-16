package com.example.rest;

import com.example.ProcessesApplication;
import com.example.helper.DateOps;
import com.example.helper.StateOps;
import com.example.helpers.StateHelper;
import com.example.model.App;
import com.example.model.State;
import com.example.service.AppService;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.core.MediaType;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    private List<App> apps;

    private DateOps dateOps = new DateOps();

    @Before
    // Create two apps with coresponding states
    public void setUp() throws Exception {
        App app1 = new App(123, "Skype", "Skype 123");
        App app2 = new App(1234, "Chrome", "Chrome 1234");

        app1.getStates().add(StateOps.startState(app1.getTitle(), dateOps));
        app1.getStates().add(StateOps.idleState(app1.getTitle(), dateOps));
        app1.getStates().add(StateOps.focusState(app1.getTitle(), dateOps));
        app1.getStates().add(StateOps.stopState(app1.getTitle(), dateOps));

        app2.getStates().add(StateOps.startState(app2.getTitle(), dateOps));

        apps = new ArrayList<>();
        apps.add(app1);
        apps.add(app2);
    }

    @After
    public void tearDown() throws Exception {
        appService.deleteAll();
    }

    @Autowired AppService appService;

    @Test
    public void update() throws Exception {
        System.out.println(gson.toJson(apps));

        mockMvc.perform(post("/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(apps))
                )
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());

        App firstApp = appService.findOne(1L);
        Assert.assertTrue(firstApp.equals(apps.get(0)));
    }

    @Test
    public void getApps() throws Exception {

        for (App app : apps) {
            appService.save(app);
        }

        mockMvc.perform(get("/apps")
                    .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].states", hasSize(4)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAppWithStateEqualsToLastState() throws Exception {
        for (App app : apps) {
            appService.save(app);
        }

        List<App> appsToUpdate = new ArrayList<>();

        App app1 = apps.get(0);
        App app2 = apps.get(1);

        State app1State = StateHelper.getLastStateForApp(app1);
        State app2State = StateHelper.getLastStateForApp(app2);

        app1.setStates(new ArrayList<State>());
        app1.getStates().add(app1State);
        app2.setStates(new ArrayList<State>());
        app2.getStates().add(app2State);

        appsToUpdate.add(app1);
        appsToUpdate.add(app2);

        mockMvc.perform(post("/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(appsToUpdate))
            )
            .andDo(print())
            .andExpect(jsonPath("$.[0].states", hasSize(4)))
            .andExpect(status().isOk());
    }

    @Test
    public void addNewState() throws Exception {
        for (App app : apps) {
            appService.save(app);
        }

        App app1 = apps.get(0);
        app1.setStates(new ArrayList<State>());
        app1.getStates().add(StateOps.startState(app1.getTitle(), dateOps));
        List<App> appsToUpdate = new ArrayList<>();
        appsToUpdate.add(app1);

        mockMvc.perform(post("/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(appsToUpdate))
            )
            .andDo(print())
            .andExpect(status().isOk());

        App firstApp = appService.findByProcessName("Skype 123");
        Assert.assertEquals(firstApp.getStates().size(), 5);
    }
}