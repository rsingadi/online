package com.dxc.service;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.dao.CustomerDao;
import com.dxc.pojo.Cart;
import com.dxc.pojo.Product;

public class CustomerService{

	CustomerDao customerDao = new CustomerDao();
	
	
	public boolean customerLogin(int id, String password) {
		return customerDao.customerLogin(id, password);
	}


	public boolean addBalance(int i, double balance) {
		return customerDao.addBalance(i, balance);
	}
	

	public List<Product> avaiableProducts() {
		return customerDao.avaiableProducts();
	}


	public List<Cart> getCartList(int id, int productNo) {
		return customerDao.getCartList(id, productNo);
	}

	
	public void payBill(int id,double amount) {
	 customerDao.payBill(id,amount);
	}

public boolean find(int ProductNo)
{
	return customerDao.find(ProductNo);
}
	

	public List<Cart> displaycart() {
		// TODO Auto-generated method stub
		return customerDao.displaycart();
	}


	public boolean addToCart(int sno,int id, int ProductNo, Product p, Cart cart, int quantity) {
		// TODO Auto-generated method stub
		return customerDao.addToCart(sno,id,ProductNo,p,cart,quantity);
	}


	public double generateBill(int id) {
		// TODO Auto-generated method stub
		return customerDao.generateBill(id);
	}


	public double getBalance(int id) {
		// TODO Auto-generated method stub
		return customerDao.getBalance(id);
	}

}
