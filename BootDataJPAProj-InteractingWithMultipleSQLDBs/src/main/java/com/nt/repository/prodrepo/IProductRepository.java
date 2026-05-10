package com.nt.repository.prodrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.prodentity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
