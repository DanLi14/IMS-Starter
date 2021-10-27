package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Oidao<T> {

	List<T> readAll();
	
	T create(T t);
	
	double calcCost(T t);
	
	int delete(long id, String name);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;

}
