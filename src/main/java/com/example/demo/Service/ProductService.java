package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Product;

public interface ProductService {

	public Page<Product> getAllProduct(Pageable page);
	public Product saveProduct(Product p);
	public Product getProductById(int pid);
	public boolean updateProduct(int pid, Product p);
	public boolean deleteById(int pid);
}
