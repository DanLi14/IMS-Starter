package com.qa.ims.controller;

import java.util.List;

public interface OiCrudController<T> {
	
	List<T> readAll();

	T create();
	
	double calcCost();
	
	int delete();

}
