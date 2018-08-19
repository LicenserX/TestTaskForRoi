package com.licenser.testtaskforroi.converters;

import com.licenser.testtaskforroi.entity.CategoryPO;
import com.licenser.testtaskforroi.entity.ProductPO;
import com.licenser.testtaskforroi.repository.ProductRepository;
import com.licenser.testtaskforroi.transfer.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductTOConverter {

    @Autowired
    private CategoryTOConverter categoryTOConverter;

    @Autowired
    private ProductRepository productRepository;

    public ProductPO convert(ProductTO product) {
        ProductPO result = null;
        if (product.getId() != null) {
            Optional<ProductPO> productPO = productRepository.findById(product.getId());
            if (productPO.isPresent()) {
                result = productPO.get();
            }
        }
        if(result == null) {
            result = new ProductPO();
        }
        result.setName(product.getName());
        result.setDescription(product.getDescription());
        Set<CategoryPO> collect = product.getCategory().stream()
                .map(c -> categoryTOConverter.convert(c)).collect(Collectors.toSet());
        result.setCategory(collect);
        return result;
    }
}
