package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepoImp;

@Service
public class ProductServImp implements ProductService {

	@Autowired
	private ProductRepoImp repoim;

	@Override
	public Page<Product> getAllProduct(Pageable page) {
			return repoim.getAllProduct(page);
	}

	@Override
	public Product saveProduct(Product p) {
		return repoim.saveProduct(p);
	}

	@Override
	public Product getProductById(int pid) {
		return repoim.getProductById(pid);
	}

	@Override
	public boolean updateProduct(int pid, Product p) {
		return repoim.updateProduct(pid, p);
	}

	@Override
	public boolean deleteById(int pid) {
		return repoim.deleteById(pid);
	}
	
}
