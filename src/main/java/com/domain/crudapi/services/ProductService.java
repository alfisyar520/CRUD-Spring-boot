package com.domain.crudapi.services;

import com.domain.crudapi.exceptions.Excep;
import com.domain.crudapi.model.entities.Product;
import com.domain.crudapi.model.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.ErrorManager;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product edit(Product productx, Long id){
        Product product = productRepo.findById(id).orElse(null);
        String result = "";

        if (product == null){
            result = "id " + id + " tidak ditemukan";
            throw new Excep(result);
        }

        product.setName(productx.getName());
        product.setDesc(productx.getDesc());
        product.setPrice(productx.getPrice());
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> product = productRepo.findById(id);
        String result = "";
        if(!product.isPresent()){
            result = "id " + id + " tidak ditemukan";
            throw new Excep(result);
        }
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void delete(Long id){
        Product product = productRepo.findById(id).orElse(null);
        String result = "";
        if (product == null){
            result = "id " + id + " tidak ditemukan";
            throw new Excep(result);
        } else {
            productRepo.deleteById(id);
        }
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
}
