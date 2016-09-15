package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
@Entity
@Table(name = "App")
@NoArgsConstructor
@Setter
@Getter
public class App extends Base {
    private long processId;
    private String title;
    private String processName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<State> states = new ArrayList<>();

    public App(long processId, String title, String processName) {
        this.processId = processId;
        this.title = title;
        this.processName = processName;
    }
}
