package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojo.Cart;
import com.dxc.pojo.Customer;
import com.dxc.pojo.Product;
import com.dxc.service.CustomerService;

@Controller
@RequestMapping("/views")
public class CustomerControllers {

	CustomerService customerService = new CustomerService();
	Customer customer = new Customer();
	String message = "";
	Product product;
	int quantity;
	private int id = 0;
	private int ProductNo=0;

	@RequestMapping("/loginCustomer")
	public String customerLogin(@RequestParam("id") int id, @RequestParam("password") String password, Model model,
			HttpSession session) {
		session.setAttribute("id",id);
		customer.setId(id);
		customer.setPassword(password);
		this.id = id;
		boolean b = customerService.customerLogin(id, password);
		if (b == true) {
			return "CustomerServices";
		} else {
			message = "Customer Login Failed";
			model.addAttribute("message", message);
			return "result";
		}

	}

	@RequestMapping("/addBalance")
	public String addBalance(@RequestParam("balance") double balance,Model m) {
		int i = id;
		customer.setBalance(balance);
		boolean b = customerService.addBalance(i, balance);
		message="Amount Added";
		m.addAttribute("message", message);
		return "result";
	}
	@RequestMapping("/availableProducts")
	public String availablelProducts(Model model) {
		List<Product> list = customerService.avaiableProducts();
		model.addAttribute("list", list);
		return "ShowProducts";
	}

	@RequestMapping("/show")
	public String show(@ModelAttribute Product product) {
		this.product = product;
		return "quantity";
	}

	@RequestMapping("/quantity")
	public String quantity(@RequestParam int quantity, Model m) {
		this.quantity = quantity;
		if (quantity <= product.getQuantity() && quantity > 0) {
			product.setQuantity(quantity);
			m.addAttribute("product", product);
			return "Confirmation";
		} else {
			message = "Quantity Exceeded / You Are Giving Zero/Less Than Zero Quantity";
			m.addAttribute("message", message);
			return "result";
		}
	}

	@RequestMapping("/cart")
	public String addToCart(@RequestParam("sno") int sno,@ModelAttribute Product p,@ModelAttribute Cart cart,HttpSession session,@RequestParam ("quantity") int quantity,Model m)
	{

		int id=(int)session.getAttribute("id");
		int ProductNo=(int)session.getAttribute("ProductNo");
		session.setAttribute("quantity",quantity);

		System.out.println("before add to cart");
		boolean b=customerService.addToCart(sno,id,ProductNo,p,cart,quantity);
		System.out.println("after add to cart");
		String msg;
		if(b==true) {
			message="PRODUCT ADDED TO THE CART !";
		}
		else {
			message="PRODUCT NOT ADDED TO THE CART !"; 
		}

		m.addAttribute("message",message);
		return "result";	
	}

	@RequestMapping("/find")
	public String addProduct(@ModelAttribute Product p,HttpSession session,Model m)
	{
		int ProductNo=p.getProductNo();
		session.setAttribute("ProductNo",ProductNo);
		boolean status=true;
		status=customerService.find(ProductNo);
		System.out.println("------------------");
		String msg;

		if(status==false)
		{
			msg="PRODUCT NOT FOUND!";
			m.addAttribute("msg", msg);
			return "result";
		}
		else 
		{
			return "quantity";
		}
	}
	@RequestMapping("/displaycart")
	public String displaycart(Model model) {
		List<Cart> list = customerService.displaycart();
		model.addAttribute("list", list);
		return "cart";
	}

	@RequestMapping("/paybill")
	public String payBill(@RequestParam int id, Model m)
	{
		
		double amount=customerService.generateBill(id);
		double balance=customerService.getBalance(id);
		if(balance>=amount)
		{
		customerService.payBill(id, amount);
		message="Bill paid successfully.";
		m.addAttribute("message", message);
		return "result";
		}
		else
		{
			message="Insufficient balance in wallet.";
		m.addAttribute("message", message);
		return "result";
		}
		}
		
	}
	

	
	


