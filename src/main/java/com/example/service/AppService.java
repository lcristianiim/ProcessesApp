package com.example.service;

import com.example.helpers.StateHelper;
import com.example.model.App;
import com.example.repo.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 16.09.2016.
 */
@Service
public class AppService {
    @Autowired
    private AppRepo repo;

    public App save(App app) {

        List<App> appExists = repo.findByProcessName(app.getProcessName());

        if (appExists.size() > 0) {
            if (! StateHelper.statesAreEqual(StateHelper.getLastStateForApp(appExists.get(0)), app.getStates().get(0))) {
                appExists.get(0).getStates().add(app.getStates().get(0));
            }
            app = appExists.get(0);
        }

        return repo.save(app);
    }

    public List<App> save(List<App> apps) {
        List<App> addedApps = new ArrayList<>();

        for (int i = 0; i < apps.size(); i++) {
            App addedApp = save(apps.get(i));
            addedApps.add(i, addedApp);
        }

        return addedApps;
    }

    public Iterable<App> findAll() {
        return repo.findAll();
    }

    public App findOne(long l) {
        return repo.findOne(l);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public App findByProcessName(String processName) {
        return repo.findByProcessName(processName).get(0);
    }
}
