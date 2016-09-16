package com.example.helpers;

import com.example.model.App;
import com.example.model.State;

/**
 * Created by internship on 16.09.2016.
 */
public class StateHelper {
    public static State getLastStateForApp(App app) {
        if (app.getStates().size() > 0) {
            return app.getStates().get(app.getStates().size() - 1);
        }
        return null;
    }

    public static boolean statesAreEqual(State state1, State state2) {
        return state1.equals(state2);
    }
}
