package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Product;

@Repository("repoim")
public class ProductRepoImp {

	@Autowired
	private ProductRepo repo;
	
	public Page<Product> getAllProduct(Pageable page)
	{
	  return repo.findAll(page); 	
	}
	public Product saveProduct(Product p)
	{
		return repo.save(p);
	}
	public Product getProductById(int pid) 
	{
		Optional op=repo.findById(pid);
		if(op.isEmpty())
		{
			return null;
		}
		else
		{
			Product p=(Product)op.get();
			return p;
		}
	}
	public boolean updateProduct(int pid, Product p)
	{
		boolean b=false;
		if(repo.existsById(pid))
		{
			p.setPid(pid);
			repo.save(p);
			b=true;
		}
		return b?true:false;
	}
	public boolean deleteById(int pid)
	{
		boolean b=false;
	     if(repo.existsById(pid))
	     {
	    	 repo.deleteById(pid);
	    	 b=true;
	     }
	     return b?true:false;
	}
}
