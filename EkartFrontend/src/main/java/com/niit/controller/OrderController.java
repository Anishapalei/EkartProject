package com.niit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.OrderDetail;
import com.niit.model.Product;

@Controller
public class OrderController {
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	ProductDAO productDAO;
	@RequestMapping(value="/cart/OrderBy/{orderId}")
	public String displayOrderBy(@PathVariable("orderId")int orderId,Model m)
	{
		OrderDetail listorderdetails=orderDAO.getOrderDetail(orderId);
		m.addAttribute("orderdet",listorderdetails);
		
	
		
		return "OrderBy";
	}
	
	@RequestMapping(value="payment")
	public String showPaymentPage()
	{
		return "Payment";
	}
	
	@RequestMapping(value="/paymentprocess",method=RequestMethod.POST)
	public String paymentProcess(@RequestParam("pmode")String pmode,HttpSession session,Model m,@AuthenticationPrincipal Principal principal)
	{
		String username=(String)session.getAttribute("username");
		String email=principal.getName();

		List<CartItem> listCartItems=cartDAO.retrieveCartItems(username);
		
			
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalValue(listCartItems));
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setUsername(username);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPmode(pmode);
		orderDetail.setTotalShoppingAmount((int)this.calcGrandTotalValue(listCartItems));
		
		orderDAO.insertOrderDetail(orderDetail);
		
		for (CartItem cartItem : listCartItems) 
		{
			Product product=productDAO.getProduct(cartItem.getProductId());
			product.setQuantity(product.getQuantity()-cartItem.getQuantity());
			productDAO.updateProduct(product);
			cartDAO.deleteCartItem(cartItem);
		}
		List<OrderDetail> currentOrder=new ArrayList<OrderDetail>();
		List<OrderDetail> listorderdetails=orderDAO.retrieveOrderDetail(username);
		for(OrderDetail od:listorderdetails)
		{
			Date d1=od.getOrderDate();
			Date d2=new Date();
			if(d1.getDate()==d2.getDate())
				currentOrder.add(od);
		}
		System.out.println("OrderDetail have been saved");
		m.addAttribute("listorder",listorderdetails);
		m.addAttribute("TodaysOrder",currentOrder);
		return "ThankYou";
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
@RequestMapping(value="/cart/myorder")
public String MyOrderProcess(@RequestParam(value="pmode",required=false)String pmode,HttpSession session,Model m)
{
String username=(String)session.getAttribute("username");

List<OrderDetail> listorderdetails=orderDAO.retrieveOrderDetail(username);
m.addAttribute("listorder",listorderdetails);

return "myorder";
}

}
