package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Product;

@Controller

public class CartController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping("/cart/cart")
	public String showCart(HttpSession session,Model m)
	{
		
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItems=cartDAO.retrieveCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalValue(listCartItems));
		
		return "Cart";
	}
	
	@RequestMapping("/cart/addToCart/{productid}")
	public String addToCart(@PathVariable("productid") int productid,@RequestParam("quantity") int quantity,HttpSession session,Model m)
	{
		System.out.println("cart quantity "+quantity);
		Product product=productDAO.getProduct(productid);
		
		CartItem cartItem=new CartItem();
		
		String username=(String)session.getAttribute("username");
		
		cartItem.setProductId(product.getProductId());
		cartItem.setProductname(product.getProductName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setPstatus("N");
		cartItem.setUsername(username);
		List<CartItem> listCartItems=cartDAO.retrieveCartItems(username);
		if(listCartItems.size()==0)
			cartDAO.addCartItem(cartItem);
		else
		{
		for(CartItem cit:listCartItems)
		{
			if(cit.getProductId()==product.getProductId())
			{
				cit.setQuantity(cit.getQuantity()+quantity);
				
			cartDAO.updateCartItem(cit);
			}
			else
				cartDAO.addCartItem(cartItem);
			
		}
		}
		listCartItems=cartDAO.retrieveCartItems(username);
		
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalValue(listCartItems));
		
		return "Cart";
	}
	
	public long calcGrandTotalValue(List<CartItem> listCartItems)
	{
		int count=0;
		long grandTotalPrice=0;
		while(count<listCartItems.size())
		{
			grandTotalPrice+=(listCartItems.get(count).getQuantity()*listCartItems.get(count).getPrice());
			count++;
		}
		
		return grandTotalPrice;
	}
	
		
	@RequestMapping(value="/cart/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItems=cartDAO.retrieveCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalValue(listCartItems));
		
		return "Cart";
	}
	@RequestMapping(value="/cart/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity") int quantity,Model m,HttpSession session)
	{
		
		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		
		String username=(String)session.getAttribute("username");
		cartItem.setQuantity(quantity);
		boolean b=cartDAO.updateCartItem(cartItem);
		
		List<CartItem> listCartItems=cartDAO.retrieveCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalValue(listCartItems));
		
		return "Cart";
	}
	
	@RequestMapping(value="checkout")
	public String checkOut(HttpSession session,Model m)
	{

		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItems=cartDAO.retrieveCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalValue(listCartItems));
		
		return "OrderDetail";
	}

}
