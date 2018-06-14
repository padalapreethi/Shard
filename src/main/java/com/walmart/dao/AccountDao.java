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
import com.walmart.model.Account;

public class AccountDao implements AccountDaoInterface<Account, String>{
	private Session currentSession;
	private Transaction currentTransaction;

	public AccountDao() {
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

	public void persist(Account entity) {
		getCurrentSession().save(entity);
	}

	public void update(Account entity) {
		getCurrentSession().update(entity);
	}

	public Account findById(long id) {
		Account book = (Account) getCurrentSession().get(Account.class, id);
		return book; 
	}

	public void delete(Account entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Account> findAll() {
		List<Account> books = (List<Account>) getCurrentSession().createQuery("from ACCOUNT").list();
		return books;
	}

	public void deleteAll() {
		List<Account> entityList = findAll();
		for (Account entity : entityList) {
			delete(entity);
		}
	}

}
