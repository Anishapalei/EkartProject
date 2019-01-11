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
import com.niit.model.Category;
import com.niit.model.Product;



@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/admin/category")
	public String showCategory(Model m)
	{
		List<Category> listCategories=categoryDAO.listCategories();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listCategories", listCategories); 
		Category category=new Category();
		m.addAttribute(category);
		return "Category";
	}
	
	@RequestMapping(value="/admin/addCategory",method=RequestMethod.POST)
	public String addCategoryDetail(@ModelAttribute("category") Category cat,Model m)
	{
		Category category=categoryDAO.getCategory(cat.getCategoryId());
			if(category==null)
			{
		categoryDAO.add(cat);
			}
			else
				categoryDAO.update(cat);
		
		List<Category> listCategories=categoryDAO.listCategories();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listCategories", listCategories); 
		
		return "Category";
	}
	
	@RequestMapping(value="/admin/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		categoryDAO.delete(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listCategories", listCategories); 
		category=new Category();
		m.addAttribute(category);
		return "redirect:/admin/category";
	}
	
	
	
		@RequestMapping(value="/admin/editCategory/{categoryId}")
		public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	
			{ 
			
			
				Category category=categoryDAO.getCategory(categoryId);
				m.addAttribute("category", category);
				List<Category> listCategories=categoryDAO.listCategories();
				//binding the listCategories and sending to jsp page
				m.addAttribute("listCategories", listCategories); 
				category=new Category();
				return "Category";
			
		
			
	}
	
	
	
}