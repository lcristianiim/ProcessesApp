package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.Timestamp;

/**
 * Created by internship on 15.09.2016.
 */
@Entity
@Setter
@Getter
@Table(name = "state")
public class State extends Base {
    private Timestamp start;
    private Timestamp stop;
    private Boolean active;
    private Boolean activeTime;
}
