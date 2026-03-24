package com.product.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.demo.Entity.product;

@Repository

public interface prodcutinterface extends JpaRepository<product, Integer>{

}


