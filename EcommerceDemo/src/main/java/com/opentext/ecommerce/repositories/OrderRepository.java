package com.opentext.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.opentext.ecommerce.models.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
