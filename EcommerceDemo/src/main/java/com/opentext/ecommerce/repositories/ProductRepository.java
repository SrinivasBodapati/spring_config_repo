package com.opentext.ecommerce.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.opentext.ecommerce.models.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{

	@Query("select prod from Product prod where prod.productName=:name")
	public Product searchProductByName(@Param("name") String name);
}
