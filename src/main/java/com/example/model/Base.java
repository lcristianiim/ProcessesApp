package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by internship on 15.09.2016.
 */
@Getter
@Setter
public class Base {
    @Id
    @GeneratedValue
    protected long id;
}
