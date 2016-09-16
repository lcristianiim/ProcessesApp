package com.example.helper;

import com.example.model.State;

/**
 * Created by internship on 16.09.2016.
 */
public class StateOps {
    public static State startState(String appName, DateOps dateOps) {
        dateOps.addRandomMinutes();
        return new State(1, dateOps.getCurrentDate().getTime(), appName);
    }

    public static State idleState(String appName, DateOps dateOps) {
        dateOps.addRandomMinutes();
        return new State(0, dateOps.getCurrentDate().getTime(), appName);
    }

    public static State focusState(String appName, DateOps dateOps) {
        dateOps.addRandomMinutes();
        return new State(2, dateOps.getCurrentDate().getTime(), appName);
    }

    public static State stopState(String appName, DateOps dateOps) {
        dateOps.addRandomMinutes();
        return new State(-1, dateOps.getCurrentDate().getTime(), appName);
    }
}
