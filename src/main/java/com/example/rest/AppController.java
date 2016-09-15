package com.example.rest;

import com.example.model.App;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

/**
 * Created by internship on 15.09.2016.
 */
@RequestMapping(value = "/apps")
public interface AppController {
    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    ResponseEntity getApps();

    @RequestMapping(value = "/{id}",method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    ResponseEntity getApp(long id);

    @RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    ResponseEntity addApp(App app);

    @RequestMapping(value = "/{id}", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    ResponseEntity updateApp(long id, App app);

    @RequestMapping(method = RequestMethod.DELETE)
    ResponseEntity deleteApps();

    @RequestMapping(value = "/{id}",method= RequestMethod.DELETE)
    ResponseEntity deleteApp(long id);
}
