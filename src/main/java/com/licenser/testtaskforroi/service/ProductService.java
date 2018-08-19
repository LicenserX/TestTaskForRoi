package com.licenser.testtaskforroi.service;

import com.licenser.testtaskforroi.converters.CategoryTOConverter;
import com.licenser.testtaskforroi.converters.ProductPOConverter;
import com.licenser.testtaskforroi.converters.ProductTOConverter;
import com.licenser.testtaskforroi.entity.ProductPO;
import com.licenser.testtaskforroi.repository.ProductRepository;
import com.licenser.testtaskforroi.transfer.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductPOConverter productPOConverter;

    @Autowired
    private ProductTOConverter productTOConverter;

    @Autowired
    private CategoryTOConverter categoryTOConverter;


    public void add(ProductTO entity) {
        ProductPO convert = productTOConverter.convert(entity);
        repository.save(convert);
    }

    public ProductTO get(Long id) {
        Optional<ProductPO> product = repository.findById(id);
        return product.map(productPO -> productPOConverter.convert(productPO)).orElse(null);
    }

    public List<ProductTO> getAll() {
        Iterable<ProductPO> all = repository.findAll();
        return productPOConverter.convert(all);
    }

    public void update(ProductTO entity) {
        ProductPO convert = productTOConverter.convert(entity);
        repository.save(convert);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ProductTO> getByName(String name) {
        List<ProductPO> products = repository.getByName(name);
        return productPOConverter.convert(products);
    }

    public List<ProductTO> getByCategory(String category) {
        List<ProductPO> products = repository.getByCategory(category);
        List<ProductTO> result = new ArrayList<>();
        for (ProductPO productPO : products) {
            result.add(productPOConverter.convert(productPO));
        }
        return result;
    }
}
