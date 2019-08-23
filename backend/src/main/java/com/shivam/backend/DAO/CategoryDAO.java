package com.shivam.backend.DAO;

import java.util.List;

import com.shivam.backend.model.Category;

public interface CategoryDAO {

	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}