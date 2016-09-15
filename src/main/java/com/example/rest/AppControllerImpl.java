package com.example.rest;

import com.example.model.App;
import com.example.repo.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
@RestController
public class AppControllerImpl implements AppController {

    @Autowired
    private AppRepo repo;

    @Override
    public ResponseEntity getApps() {
        return null;
    }

    @Override
    public ResponseEntity updateApps(@RequestBody List<App> apps) {
        List<App> addedApps = new ArrayList<>();

        for (int i = 0; i < apps.size(); i++) {
            App addedApp = repo.save(apps.get(i));
            addedApps.add(i, addedApp);
        }

        return ResponseEntity.ok().body(addedApps);
    }
}
