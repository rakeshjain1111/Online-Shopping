package com.rakesh.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String code;
	
	@NotBlank(message = "Please Enter The Product Name")
	private String name;
	@NotBlank(message = "Please Enter The Brand Name")
	private String brand;
	@JsonIgnore
	@NotBlank(message = "Please Enter The Description for Product")
	private String description;
	@Column(name="unit_price")
	@Min(value=1, message="The Price cannot be less than 1!")
	private float unitPrice;
	private int quantity;
	@Column(name="category_id")
	@JsonIgnore
	private int categoryId;
	@Column(name="is_active")
	private boolean active;
	@Column(name="supplier_id")
	@JsonIgnore
	private int supplierId;
	private int purchases;
	private int views;
	@Transient
	private MultipartFile file;
	
	public Product() {
		this.code = "PRO"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", categoryId=" + categoryId
				+ ", active=" + active + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views=" + views
				+ ", file=" + file + "]";
	}
	

	
}
