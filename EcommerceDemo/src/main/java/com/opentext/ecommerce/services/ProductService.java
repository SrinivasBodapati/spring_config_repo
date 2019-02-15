package com.opentext.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opentext.ecommerce.models.Product;
import com.opentext.ecommerce.repositories.ProductRepository;
@Service
public class ProductService {
    @Autowired 
	private ProductRepository productRepo;
   
    
    public boolean addProduct(Product product)
    {
    	boolean status=false;
        //insert query	
    	if(productRepo.save(product)!=null)
    		status=true;
    	return status;
    }
    
    public Product searchProductById(long id)
    {
    	//select with where condition
    	return productRepo.findById(id).orElse(new Product());
    }
    
    
    public Product findProductByName(String name)
    {
    	//select with where condition
    	return productRepo.searchProductByName(name);
    }
    
    public List<Product> getAllProducts()
    {
    	List<Product> productList=new ArrayList<Product>();
    	
    	// select * from Product
    	productRepo.findAll().forEach(productList::add);
    		return productList;   	
    	
    }
	
    public boolean deleteProductById(long id)
    {
    	boolean status=false;
    	//delete by id
    	productRepo.deleteById(id);
    	status=true;
    	return status;
    }
    
    
    
    
	
}
