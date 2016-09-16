package com.example.rest;

import com.example.model.App;
import com.example.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
@RestController
public class AppControllerImpl implements AppController {

    @Autowired
    private AppService appService;

    @Override
    public ResponseEntity getApps() {
        return ResponseEntity.ok().body((List<App>) appService.findAll());
    }

    @Override
    public ResponseEntity updateApps(@RequestBody List<App> apps) {
        return ResponseEntity.ok().body(appService.save(apps));
    }
}
