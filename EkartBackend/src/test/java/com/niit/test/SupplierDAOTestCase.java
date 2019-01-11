package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

/*public class SupplierDAOTestCase {
	static SupplierDAO supplierDAO;
	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void executeFirst()
	{
		context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
		
		@Test
		public void addProductTest()
		{
			Supplier supplier=new Supplier();
			
			supplier.setSupplierId(201);
			supplier.setSupplierName("Aakriti");
			supplier.setSupplierAddr("Jayanagar");
			assertTrue("Probem in Adding the supplier",supplierDAO.add(supplier));
		}

}*/