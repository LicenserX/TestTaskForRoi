package com.licenser.testtaskforroi.repository;

import com.licenser.testtaskforroi.entity.CategoryPO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryPO, Long> {
}
