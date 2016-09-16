package com.example.helper;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by internship on 16.09.2016.
 */
@Setter
@Getter
public class DateOps {
    private Calendar calendar = Calendar.getInstance();

    public Date getCurrentDate() {
        return calendar.getTime();
    }

    public Date addMinutes(int minutes) {
        calendar.add(Calendar.MINUTE, minutes);
        return getCurrentDate();
    }

    public void addRandomMinutes() {
        addMinutes(Number.generateRandomNumber());
    }
}
