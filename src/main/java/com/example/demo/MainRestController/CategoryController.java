package com.example.demo.MainRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Category;
import com.example.demo.Service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService serv;
	
	@GetMapping
	public Page<Category> getAllCategory(Pageable page)
	{
		return serv.getAllCategory(page);
	}
	
   @PostMapping
   public String addCategory(@RequestBody Category c)
   {
	   boolean b=serv.addCategory(c);
	   return b?"Success":"Something Worng";
   }
   
   @GetMapping("{cid}")
   public Category getCategory(@PathVariable("cid")Integer id)
   {
	   
	   Category l=serv.getCategoryById(id);
	   if(l!=null)
		  {
			  return l;
		  }
		  else
		  {
			 return null;
		  }	  
   }
   @PutMapping("{cid}")
   public String updateCategory(@PathVariable("cid")Integer cid,@RequestBody Category c)
   {
	   boolean b=serv.updateCategory(cid, c);
	   return b?"Updated Success..":"something wrong";
   }
   
   @DeleteMapping("{cid}")
   public String CategoryDelete(@PathVariable("cid") Integer cid)
   {
	   boolean b=serv.deleteCategory(cid);
	   return b?"Deleted Success..":"Something Wrong";
   }
}
