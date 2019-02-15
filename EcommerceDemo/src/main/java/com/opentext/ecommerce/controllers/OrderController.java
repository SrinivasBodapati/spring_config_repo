package com.opentext.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.ecommerce.models.Product;
import com.opentext.ecommerce.models.TempOrder;
import com.opentext.ecommerce.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	@RequestMapping(path="/addorder",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean addProduct(@RequestBody TempOrder order )
	{
		/*for(long id : order.getProductId())
		{
			System.out.println(id);
		}
		System.out.println(order.getAddress());*/
		orderService.addOrder(order.getAddress(), order.getProductId());
		
		return true;
	}
	
}
