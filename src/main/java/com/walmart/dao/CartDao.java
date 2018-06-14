/**
 * 
 */
package com.walmart.dao;

/**
 * @author p0p00bj
 *
 */
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.walmart.model.Cart;

public class CartDao implements CartDaoInterface<Cart, String>{
	
	private Session currentSession;
	
	private Transaction currentTransaction;

	public CartDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Cart entity) {
		getCurrentSession().save(entity);
	}

	public void update(Cart entity) {
		getCurrentSession().update(entity);
	}

	public Cart findById(long id) {
		Cart book = (Cart) getCurrentSession().get(Cart.class, id);
		return book; 
	}

	public void delete(Cart entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Cart> findAll() {
		List<Cart> books = (List<Cart>) getCurrentSession().createQuery("from Cart").list();
		return books;
	}

	public void deleteAll() {
		List<Cart> entityList = findAll();
		for (Cart entity : entityList) {
			delete(entity);
		}
	}

}
