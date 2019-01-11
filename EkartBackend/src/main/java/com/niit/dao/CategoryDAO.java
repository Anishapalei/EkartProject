package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Category;
@Repository("categoryDAO")
public interface CategoryDAO 
{
	public boolean add(Category category);
	public boolean delete(Category category);
	public boolean update(Category category);
	public List<Category> listCategories();
	public Category getCategory(int categoryId);

}
