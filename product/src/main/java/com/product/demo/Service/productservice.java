package com.product.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.Entity.product;
import com.product.demo.Repository.prodcutinterface;
import com.product.demo.serviceimpl.serviceinterface;
@Service
public class productservice  implements serviceinterface{

	 @Autowired
	    prodcutinterface repository;

	    public List<product> getAllproduct() {
	        return repository.findAll();
	    }

	    public product saveProduct(product product) {
	        return repository.save(product);
	    }

	    public product getproductyId(int id) {
	        return repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	    }

	    public void deleteById(int id) {
	        repository.deleteById(id);
	    }

}
