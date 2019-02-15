package com.opentext.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.ecommerce.models.Product;
import com.opentext.ecommerce.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(path="/addproduct",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
		
	}
	
	@RequestMapping(path="/getallproducts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> findAllProducts()
	{
		return productService.getAllProducts();
		
	}
	
	@RequestMapping(path="/getproductbyid/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product findProductById(@PathVariable long id)
	{
		return productService.searchProductById(id);
		
	}
	
	@RequestMapping(path="/getproductbyname/{name}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product searchProductByName(@PathVariable String name)
	{
		return productService.findProductByName(name);
		
	}
}
