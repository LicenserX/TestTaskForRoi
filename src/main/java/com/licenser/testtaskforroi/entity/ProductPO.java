package com.licenser.testtaskforroi.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "UC_PRODUCT", columnNames = {"name"})}, name = "PRODUCT")
public class ProductPO extends AbstractPO {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "PRODUCT_X_CATEGORY",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    @Size(min = 1)
    private Set<CategoryPO> category;

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

    public Set<CategoryPO> getCategory() {
        return category;
    }

    public void setCategory(Set<CategoryPO> category) {
        this.category = category;
    }
}
