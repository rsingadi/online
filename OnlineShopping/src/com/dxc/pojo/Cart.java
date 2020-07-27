package com.dxc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	private int sno;
	private int id;
	private int ProductNo;
	private int quantity;
	private double grandTotal;
	private double totalDiscount;
	private double payableAmount;
	


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getProductNo() {
		return ProductNo;
	}


	public void setProductNo(int productNo) {
		ProductNo = productNo;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}


	public double getTotalDiscount() {
		return totalDiscount;
	}


	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}


	public double getPayableAmount() {
		return payableAmount;
	}


	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}


	@Override
	public String toString() {
		return "Cart [sno=" + sno + ", id=" + id + ", ProductNo=" + ProductNo + ", quantity=" + quantity
				+ ", grandTotal=" + grandTotal + ", totalDiscount=" + totalDiscount + ", payableAmount=" + payableAmount
				+ "]";
	}


	

	

	
	
}