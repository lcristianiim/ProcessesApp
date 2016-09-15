package com.example.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class State extends Base {
    private int start;
    private int stop;
    private Boolean active;
    private int activeTime;
}
