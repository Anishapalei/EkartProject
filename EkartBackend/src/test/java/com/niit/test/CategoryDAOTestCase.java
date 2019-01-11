/*package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTestCase {

	static CategoryDAO categoryDAO;
	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void executeFirst()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		
		category.setCategoryName("Mobiles");
		category.setCategoryDesc("Mobiles under 15000");
		
		assertTrue("Probem in Adding the Category",categoryDAO.add(category));
	}
		
	
}*/