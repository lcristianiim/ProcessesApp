package com.example.model;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Timestamp;

/**
 * Created by internship on 15.09.2016.
 */
@Entity
@Setter
@Getter
@Table(name = "state")
@NoArgsConstructor
public class State extends Base {
    private long start;
    private long stop;
    private Boolean active;
    private long time;

    public State(long start, long stop, Boolean active, long time) {
        this.start = start;
        this.stop = stop;
        this.active = active;
        this.time = time;
    }
}
