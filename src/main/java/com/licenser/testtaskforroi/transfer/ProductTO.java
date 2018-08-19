package com.licenser.testtaskforroi.transfer;

import java.util.HashSet;
import java.util.Set;

public class ProductTO {

    private Long id;

    private String name;

    private String description;

    private Set<CategoryTO> category = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CategoryTO> getCategory() {
        return category;
    }

    public void setCategory(Set<CategoryTO> category) {
        this.category = category;
    }

}
