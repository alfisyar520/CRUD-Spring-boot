package com.domain.crudapi.controllers;

import com.domain.crudapi.model.entities.Product;
import com.domain.crudapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productService.findOne(id);
    }

//    @PutMapping("/{id}")
    @RequestMapping(value = "/{id}",method=RequestMethod.PUT)
    public Product update(@PathVariable("id") Long id, @RequestBody Product product){
       return productService.edit(product, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
