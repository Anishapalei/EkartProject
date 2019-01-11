package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;
@Repository("supplierDAO")
public interface SupplierDAO 
{
	public boolean add(Supplier supplier);
	public boolean delete(Supplier supplier);
	public boolean update(Supplier supplier);
	public List<Supplier > listSuppliers();
	public Supplier  getSupplier(int supplierId);

}
