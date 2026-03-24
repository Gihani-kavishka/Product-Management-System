package com.product.demo.serviceimpl;

import java.util.List;

import com.product.demo.Entity.product;

public interface serviceinterface {

	
	 List<product> getAllproduct();

	 product saveProduct(product product);

	    product getproductyId(int id);

	    void deleteById(int id);
}
