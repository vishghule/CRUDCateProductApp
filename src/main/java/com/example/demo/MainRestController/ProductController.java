package com.example.demo.MainRestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public Page<Product> getAllProducts(Pageable page) throws JsonProcessingException
	{
      return  service.getAllProduct(page);
	}
	
	@PostMapping
	public String saveProduct(@RequestBody Product p)
	{
		Product p1= service.saveProduct(p);
		return p1!=null?"Product Added Success..":"Something Wrong..";
	}
	@GetMapping("{pid}")
	public Product getProductById(@PathVariable("pid") Integer pid)
	{
		return service.getProductById(pid);
	}
	@PutMapping("{pid}")
	public String updateProductById(@PathVariable("pid")Integer pid,@RequestBody Product p)
	{
		boolean b= service.updateProduct(pid, p);
		return b?"Updated Success..":"Something wrong..";
	}
	@DeleteMapping("{pid}")
	public String deleteProductById(@PathVariable("pid")Integer pid)
	{
		boolean b= service.deleteById(pid);
		return b?"deleted Success..":"Something wrong..";
	}
	
}
