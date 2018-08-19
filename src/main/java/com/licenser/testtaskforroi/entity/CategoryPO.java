package com.licenser.testtaskforroi.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(name = "UC_CATEGORY", columnNames={"type"})}, name = "CATEGORY")
public class CategoryPO extends AbstractPO{

    @Column(name = "type", nullable = false)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
