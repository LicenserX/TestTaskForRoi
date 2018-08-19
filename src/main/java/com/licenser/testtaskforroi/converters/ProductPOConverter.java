package com.licenser.testtaskforroi.converters;

import com.licenser.testtaskforroi.entity.ProductPO;
import com.licenser.testtaskforroi.transfer.CategoryTO;
import com.licenser.testtaskforroi.transfer.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductPOConverter {

    @Autowired
    private CategoryPOConverter categoryPOConverter;

    public List<ProductTO> convert(Iterable<ProductPO> products) {
        List<ProductTO> resultList = new ArrayList<>();
        for (ProductPO product : products) {
            resultList.add(convert(product));
        }
        return resultList;
    }

    public ProductTO convert(ProductPO product) {
        ProductTO result = new ProductTO();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setDescription(product.getDescription());
        Set<CategoryTO> categories = product.getCategory()
                .stream().map(c -> categoryPOConverter.convert(c)).collect(Collectors.toSet());
        result.setCategory(categories);
        return result;
    }
}
