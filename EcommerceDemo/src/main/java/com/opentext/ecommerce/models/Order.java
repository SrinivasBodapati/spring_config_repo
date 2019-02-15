package com.opentext.ecommerce.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
@Entity
@Table(name="OPENTEXT_ORDER")
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "prototype")
public class Order {

	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Order_Id")
	private int orderId;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.MERGE)
    @JsonIgnore
	private List<Product> productList;

	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Column(name="Address")
	private String address;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
