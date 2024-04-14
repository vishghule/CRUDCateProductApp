package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepoImpl;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepoImpl repo;

	@Override
	public Page<Category> getAllCategory(Pageable page) {
		return repo.getAllCategory(page);
	}

	@Override
	public boolean addCategory(Category c) {
		return repo.addCategory(c);
	}

	@Override
	public Category getCategoryById(int id) {
		return repo.getCategoryById(id);
	}

	@Override
	public boolean deleteCategory(int id) {
		return repo.deleteCategory(id);
	}

	@Override
	public boolean updateCategory(int cid, Category c) {
		return repo.updateCategory(cid, c);
	}
}
