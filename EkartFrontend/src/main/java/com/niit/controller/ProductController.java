

package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
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
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller

public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	private Path path;
	
	@RequestMapping(value="/cart/categorywise/{categoryId}")
	public String displayCategoryWise(@PathVariable("categoryId")int categoryId,Model m)
	{
		List<Product> listProducts=productDAO.listCategoryWiseProducts(categoryId);
		m.addAttribute("productlist", listProducts);
		
	
		
		return "UserHome";
	}
	
	@RequestMapping(value="/admin/product")
	public String showProductPage(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		Product product=new Product();
		m.addAttribute(product);
		List<Category> listCategory=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
		
		
		return "Product";
	}
	
	@RequestMapping(value="/admin/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile prodImage,Model m,HttpServletRequest request)
	{
		//Displaying Content
		System.out.println("Product Name:"+product.getProductName());
		System.out.println("Product Desc:"+product.getProductDesc());
		System.out.println("Category ID:"+product.getCategoryId());
		System.out.println("Price:"+product.getPrice());
		System.out.println("Quantity:"+product.getQuantity());
		Product pro=productDAO.getProduct(product.getProductId());
		if(pro==null)
		{
	productDAO.addProduct(product);
		}
		else
			productDAO.updateProduct(product);
		
		//Start-Image Insertion
		
		
		String rootDirectory=request.getSession().getServletContext().getRealPath("/")+ "\\WEB-INF\\resources\\images\\";
		/*path=Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getPro_id()+".jpg");*/
		path = Paths.get(rootDirectory  + product.getProductId() + ".jpg");
		System.out.println(path);
	
	
		if(!prodImage.isEmpty())
		{
			try
			{
				prodImage.transferTo(new File(path.toString()));
				System.out.println(path);
				
//				byte[] buffer=prodImage.getBytes();
//				FileOutputStream fos=new FileOutputStream(rootDirectory);
//				BufferedOutputStream bs=new BufferedOutputStream(fos);
//				bs.write(buffer);
//				bs.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
				m.addAttribute("Error","Exception Occured during the Image Uploading"+e);	
			}
		}
		else
		{
			System.out.println("error occured");
			m.addAttribute("Error","Error Occured during the Image Uploading");
		}
		
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		List<Category> listCategory=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
		List<Supplier> listSupplier=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", this.getSupplierList(supplierDAO.listSuppliers()));
		
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory)	
	{
		LinkedHashMap<Integer,String> listCategories=new LinkedHashMap<Integer,String>();
		
		for(Category category:listCategory)
		{
			listCategories.put(category.getCategoryId(),category.getCategoryName());
		}
		return listCategories;
	}

	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> listSupplier)	
	{
		LinkedHashMap<Integer,String> listSuppliers=new LinkedHashMap<Integer,String>();
		
		for(Supplier supplier:listSupplier)
		{
			listSuppliers.put(supplier.getSupplierId(),supplier.getSupplierName());
		}
		return listSuppliers;
	}

	@RequestMapping(value="/admin/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		 Product product1=new Product();
		 m.addAttribute("product", product1);
		List<Product> listProducts=productDAO.listProducts();
		//binding the listCategories and sending to jsp page
		m.addAttribute("productlist", listProducts); 
		List<Category> listCategory=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
		List<Supplier> listSupplier=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", this.getSupplierList(supplierDAO.listSuppliers()));
		return "Product";
	}
	@RequestMapping(value="/admin/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		
		 m.addAttribute("product", product);
		List<Product> listProducts=productDAO.listProducts();
		//binding the listCategories and sending to jsp page
		m.addAttribute("productlist", listProducts); 
		List<Category> listCategory=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
		List<Supplier> listSupplier=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", this.getSupplierList(supplierDAO.listSuppliers()));
		 
		return "Product";
	}
	
	
		@RequestMapping(value="/cart/productDisplay")
		public String productDisplay(Model m)
		{
			List<Product> listProducts=productDAO.listProducts();
			m.addAttribute("productlist", listProducts);
			List<Category> listCategories=categoryDAO.listCategories();
			m.addAttribute("categoryList", listCategories);
			
			return "ProductDisplay";
		}
		@RequestMapping(value="/cart/totalProductDisplay/{productId}")
		public String productDisplay(@PathVariable("productId")int productId,Model m)
		{
			Product product=productDAO.getProduct(productId);
			m.addAttribute("product",product);
			
		
			return "TotalProductDisplay";
		}
	}
