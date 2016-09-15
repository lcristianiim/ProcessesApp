package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
@Entity
@Setter
@Getter
@Table(name = "App")
public class App extends Base {
    private long processId;
    private String title;
    private String processName;
    @OneToMany
    List<State> states = new ArrayList<>();
}
