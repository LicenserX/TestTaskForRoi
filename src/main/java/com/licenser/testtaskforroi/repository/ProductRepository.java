package com.licenser.testtaskforroi.repository;

import com.licenser.testtaskforroi.entity.ProductPO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductPO, Long>, Product {
}
