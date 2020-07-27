package com.dxc.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojo.Administrator;
import com.dxc.pojo.Cart;
import com.dxc.pojo.Customer;
import com.dxc.pojo.Product;

public class CustomerDao {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}


	public boolean customerLogin(int id, String password) {
		Session session = sessionFactory.openSession();
		Query query1 = session.createQuery("from Customer where id=:id and password=:password");
		query1.setParameter("id", id);
		query1.setParameter("password", password);

		List<Customer> list = query1.getResultList();
		for (Customer l : list) {
			if (id == l.getId() && password.equals(l.getPassword())) {
				return true;
			}
		}

		return false;
	}


	public boolean addBalance(int i, double balance) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer where id=:id");
		query.setParameter("id", i);
		List<Customer> list = query.getResultList();
		for(Customer c : list) {
			balance = c.getBalance() + balance;
			Query query1 = session.createQuery("update Customer set balance=:balance where id=:id");
			query1.setParameter("id", i);
			query1.setParameter("balance", balance);
			query1.executeUpdate();
			return true;
		}
		return false;
	}

	
	public List<Product> avaiableProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		return query.getResultList();
	}

	public boolean find(int ProductNo) {
		Product v=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where ProductNo=:ProductNo");
		query.setParameter("ProductNo", ProductNo);
		List<Product> v1=query.getResultList();
		try {
			v=v1.get(0);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean addToCart(int sno,int id, int ProductNo, Product p, Cart cart, int quantity) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query1 = session.createQuery("from Product where ProductNo=:ProductNo");
		query1.setParameter("ProductNo",ProductNo);
		List<Product> list = query1.getResultList();
		System.out.println(list);



		Product p1 = list.get(0);
		if (p1.getQuantity() >=quantity) {



			double discount = p1.getProductPrice() / p1.getDiscount();
			double grandtotal = quantity * p1.getProductPrice(); 
			double totdiscount = (quantity * discount) * 2;
			double payableAmount = grandtotal - totdiscount;
            cart.setSno(sno);
			cart.setId(id);
			cart.setProductNo(p1.getProductNo());
			cart.setQuantity(quantity);
			cart.setGrandTotal(grandtotal);
			cart.setTotalDiscount(totdiscount);
			cart.setPayableAmount(payableAmount);
			Session session1 = sessionFactory.openSession();
			session1.beginTransaction();
			session1.save(cart);
			session1.getTransaction().commit();
            
			return true;
		}
		return false;



	}

	
	public boolean isAvailable(int ProductNo) {
		Product p1 = null;
		Session session = sessionFactory.openSession();
		Query query2 = session.createQuery("from Product where ProductNo=:ProductNo");
		query2.setParameter("ProductNo", ProductNo);
		List<Product> list1 = query2.getResultList();
		try {
			p1 = list1.get(0);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public List<Cart> getCartList(int id, int productNo) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where id=:id AND productNo=:productNo");
		query.setParameter("id", id);
		query.setParameter("productNo", productNo);
		return query.getResultList();
	}
	public void payBill(int id, double amount) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	    Query query=session.createQuery("from Customer where id=:id");
	    query.setParameter("id", id);
		List<Customer> list=query.getResultList();
		Customer c=list.get(0);
		System.out.println(c.getBalance());
		System.out.println(amount);
		double balance=c.getBalance()-amount;
		System.out.println(balance);
		Query query1 = session.createQuery("update Customer set balance=:balance where id=:id");
		query1.setParameter("id",id);
		query1.setParameter("balance", balance);
		query1.executeUpdate();
		session.getTransaction().commit();
		session.close();
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
        Query query2=session1.createQuery("delete from Cart where id=:id");
	    query2.setParameter("id",id);
	    query2.executeUpdate();
        session1.getTransaction().commit();
		session1.close();
	}



	public List<Cart> displaycart() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart");
		List<Cart> list = query.getResultList();
		return list;
	
	}	
	public double getBalance(int id) 
	{
		System.out.println(id);
		double balance=0.0;
		Customer c=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer where id=:id");
		query.setParameter("id", id);
		List<Customer> cust=query.getResultList();
		c=cust.get(0);
		balance=c.getBalance();
		System.out.println(balance);
		session.close();
		return balance;
	}

	public double generateBill(int id) 
	{
		double amount=0.0;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Cart where id=:id");
		query.setParameter("id", id);
		
		List<Cart> list = query.getResultList();
		for(Cart c:list) 
		{
		 amount=amount+c.getPayableAmount();
		}
		System.out.println(amount);
		session.getTransaction().commit();
		session.close();
		return amount;
	}
	}




