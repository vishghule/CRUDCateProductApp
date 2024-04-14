package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Category;

@Repository
public class CategoryRepoImpl {

	@Autowired
	private CategoryRepository repo;
	
	
	public Page<Category> getAllCategory(Pageable page) {
		return repo.findAll(page);
		
	}
	
	public boolean addCategory(Category c) {
		Category c1=repo.save(c);
		return c1!=null?true:false;
	}
	public Category getCategoryById(int id)
	{
		Optional ob=repo.findById(id);
		if(ob.isEmpty())
		{
			return null;
		}
		else
		{
			Category c=(Category)ob.get();
			return c;
		}	
	}
	
	public boolean deleteCategory(int id)
	{
		boolean b=false;
		List<Category> l=repo.findAll();
		for(Category c:l)
		{
			if(c.getCid()==id)
			{
				repo.deleteById(id);
				b=true;
				break;
			}
		}
		return b?true:false;
	}
	public boolean updateCategory(int cid, Category c) 
	{
		boolean b=false;
		if(repo.existsById(cid))
		{
			c.setCid(cid);
			repo.save(c);
			b= true;
		}
		return b?true:false;
	}
			
	
}
