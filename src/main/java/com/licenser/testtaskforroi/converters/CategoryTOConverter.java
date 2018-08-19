package com.licenser.testtaskforroi.converters;

import com.licenser.testtaskforroi.entity.CategoryPO;
import com.licenser.testtaskforroi.repository.CategoryRepository;
import com.licenser.testtaskforroi.transfer.CategoryTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryTOConverter {

    @Autowired
    private CategoryRepository categoryRepository;

    CategoryPO convert(CategoryTO category) {
        CategoryPO result;
        if (category.getId() != null) {
            Optional<CategoryPO> optionalCategoryPO = categoryRepository.findById(category.getId());
            if (optionalCategoryPO.isPresent()) {
                return optionalCategoryPO.get();
            }
        }
        result = new CategoryPO();
        result.setType(category.getType());
        return result;
    }
}
