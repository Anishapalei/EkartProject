package com.niit.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;



@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/admin/supplier")
	public String showSupplier(Model m)
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	
		m.addAttribute("listSuppliers", listSuppliers); 
		Supplier supplier=new Supplier();
		m.addAttribute(supplier);
		return "Supplier";
	}
	
	@RequestMapping(value="/admin/addSupplier",method=RequestMethod.POST)
	public String addSupplierDetail(@ModelAttribute("supplier") Supplier sup,Model m)
	{
	
	Supplier supplier=supplierDAO.getSupplier(sup.getSupplierId());
		if(supplier==null)
		{
			supplierDAO.add(sup);
		}
		else
		supplierDAO.update(sup);

		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers); 

		return "Supplier";
	}
	
	@RequestMapping(value="/admin/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.delete(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		
		m.addAttribute("listSuppliers", listSuppliers); 
		Supplier supplier1=new Supplier();
		m.addAttribute(supplier1);
		return "Supplier";
	}
	
	/*@RequestMapping(value="/admin/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("supplierId")int supplierId,@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddr") String supplierAddr ,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplier.setSupplierId(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		
		supplierDAO.update(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listSuppliers", listSuppliers);  
		return "Supplier";
	}*/
	
		@RequestMapping(value="/admin/editSupplier/{supplierId}")
		public String editSupplier(@PathVariable("supplierId")int supplierId,Model m)
	
			{
				Supplier supplier=supplierDAO.getSupplier(supplierId);
				m.addAttribute("supplier", supplier);
				List<Supplier> listSuppliers=supplierDAO.listSuppliers();
				//binding the listCategories and sending to jsp page
				m.addAttribute("listSuppliers", listSuppliers);
				supplier=new Supplier();
			
				return "Supplier";
			
		
			
	}
	
	
	
}