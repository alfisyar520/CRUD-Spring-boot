package com.domain.crudapi.services;

import com.domain.crudapi.model.entities.Product;
import com.domain.crudapi.model.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
//        if(!product.isPresent())
        return productRepo.save(product);
    }

    public Product edit(Long id){
        Optional<Product> product = productRepo.findById(id);
        return product.get();

//        return null;
    }

    //nambahin edit, delete jika tidak ada dlm database

    public Product findOne(Long id){
        Optional<Product> product = productRepo.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void delete(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
}
