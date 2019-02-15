package com.opentext.ecommerce.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
@Component
@Entity
@Table(name="PRODUCT")
public class Product {
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Product_Id")
	private long productId;
	@Column(name="Product_Name",nullable=false,length=50)
	private String productName;
	@Column(name="Product_COST")
	private int cost;
	@Column(name="Purchase_Date",nullable=false,length=12)
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date dop;
	@Column(name="Expiry_Date",nullable=false,length=12)
	@Temporal(TemporalType.DATE)
	 @JsonFormat(pattern="yyyy-MM-dd")
	private Date doe;
	
	@ManyToOne
	@JoinColumn(name = "Order_Id", nullable = true)	
	private Order order;

	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Date getDop() {
		return dop;
	}
	public void setDop(Date dop) {
		this.dop = dop;
	}
	public Date getDoe() {
		return doe;
	}
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	
	
	

}
