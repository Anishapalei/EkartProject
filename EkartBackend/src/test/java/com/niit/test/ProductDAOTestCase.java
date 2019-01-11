/*package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductDAOTestCase {
	static ProductDAO productDAO;
	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void executeFirst()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
		@Ignore
		@Test
		public void addProductTest()
		{
			Product product=new Product();
			
			product.setProductName("Iphone");
			product.setProductDesc("Iphone 6s (Gold, 16 GB)");
			
			product.setSupplierId(1001);
			product.setCategoryId(1);
			assertTrue("Probem in Adding the Product",productDAO.addProduct(product));
			
			
			
		}
		
		
			

}
*/