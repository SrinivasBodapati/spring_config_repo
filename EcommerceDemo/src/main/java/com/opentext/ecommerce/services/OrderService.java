package com.opentext.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.opentext.ecommerce.models.Order;
import com.opentext.ecommerce.models.Product;
import com.opentext.ecommerce.repositories.OrderRepository;
import com.opentext.ecommerce.repositories.ProductRepository;

@Service
public class OrderService {

	
	 @Autowired 
		private OrderRepository orderRepo;
	 
	 @Autowired
	    private ProductService productService;
	 @Autowired
	   private Order getInstance;
	 
	 
	 @Autowired
	    private Product product;
	    
	    public boolean addOrder(String address, long[] productId)
	    {
	    	boolean status=false;
	    	//Order order=new Order();
	    	getInstance.setAddress(address);
	    	
	    	Order respOrder=orderRepo.save(getInstance);
	        //insert query	
	    	if(respOrder!=null)
	    	{
	    		for(long id : productId)
	    		{
	    			product=productService.searchProductById(id);
	    			product.setOrder(respOrder);
	    			productService.addProduct(product);
	    		}
	    		
	    		status=true;
	    		
	    	}
	    	return status;
	    }
	    
	    
	    
	
}
