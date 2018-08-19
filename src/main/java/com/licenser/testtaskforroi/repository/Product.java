package com.licenser.testtaskforroi.repository;

import com.licenser.testtaskforroi.entity.ProductPO;

import java.util.List;

public interface Product {
    List<ProductPO> getByName(String name);
    List<ProductPO> getByCategory(String type);
}
