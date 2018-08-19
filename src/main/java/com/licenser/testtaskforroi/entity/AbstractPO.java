package com.licenser.testtaskforroi.entity;


import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
}
