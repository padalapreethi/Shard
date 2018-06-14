/**
 * 
 */
package com.walmart.dao;

/**
 * @author p0p00bj
 *
 */
import java.io.Serializable;
import java.util.List;

public interface CartDaoInterface <T, Id extends Serializable> {

	public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(long id);
	
	public void delete(T entity);
	
	public List<T> findAll();
	
	public void deleteAll();
	
}
