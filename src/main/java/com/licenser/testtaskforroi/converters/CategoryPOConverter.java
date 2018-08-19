package com.licenser.testtaskforroi.converters;

import com.licenser.testtaskforroi.entity.CategoryPO;
import com.licenser.testtaskforroi.transfer.CategoryTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryPOConverter {

    CategoryTO convert(CategoryPO category) {
        CategoryTO result = new CategoryTO();
        result.setId(category.getId());
        result.setType(category.getType());
        return result;
    }

}
