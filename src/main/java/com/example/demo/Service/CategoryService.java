package com.example.demo.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Category;

public interface CategoryService  {

	public Page<Category> getAllCategory(Pageable page);
	public boolean addCategory(Category c);
	public Category getCategoryById(int cid);
	public boolean deleteCategory(int cid);
	public boolean updateCategory(int cid,Category c);
	
}
