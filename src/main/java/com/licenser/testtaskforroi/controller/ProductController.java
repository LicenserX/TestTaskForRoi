package com.licenser.testtaskforroi.controller;

import com.licenser.testtaskforroi.service.ProductService;
import com.licenser.testtaskforroi.transfer.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @javax.transaction.Transactional(rollbackOn = Exception.class)
    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public void add(@RequestBody ProductTO product) {service.add(product);}

    @RequestMapping(method = RequestMethod.GET, value = "/get_products")
    public List<ProductTO> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_product")
    public ProductTO get(Long id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/product")
    public void update(@RequestBody ProductTO product) {
        service.update(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/remove_product")
    public void delete(Long id) {
        service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_product_by_name")
    public List<ProductTO> get(String name) {
        return service.getByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_product_by_category")
    public List<ProductTO> getByCategory(String type) {
        return service.getByCategory(type);
    }

}
