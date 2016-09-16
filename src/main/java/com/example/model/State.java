package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by internship on 15.09.2016.
 */
@Entity
@Setter
@Getter
@Table(name = "state")
@NoArgsConstructor
public class State extends Base {
    /* -1 Stopped; 0 Idle; 1 Started; 2 Focus */
    private int status;
    private long time;
    private String appName;

    public State(int status, long time, String appName) {
        this.status = status;
        this.time = time;
        this.appName = appName;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        if (getStatus() != state.getStatus()) return false;
        return getAppName().equals(state.getAppName());

    }

    @Override
    public int hashCode() {
        int result = getStatus();
        result = 31 * result + getAppName().hashCode();
        return result;
    }
}
