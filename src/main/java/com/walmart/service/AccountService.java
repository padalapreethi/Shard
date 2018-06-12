/**
 * 
 */
package com.walmart.service;

/**
 * @author p0p00bj
 *
 */

import java.util.List;
import com.walmart.dao.AccountDao;
import com.walmart.model.Account;

public class AccountService {

	private static AccountDao AccountDao;

	public AccountService() {
		AccountDao = new AccountDao();
	}

	public void persist(Account entity) {
		AccountDao.openCurrentSessionwithTransaction();
		AccountDao.persist(entity);
		AccountDao.closeCurrentSessionwithTransaction();
	}

	public void update(Account entity) {
		AccountDao.openCurrentSessionwithTransaction();
		AccountDao.update(entity);
		AccountDao.closeCurrentSessionwithTransaction();
	}

	public Account findById(String id) {
		AccountDao.openCurrentSession();
		Account book = AccountDao.findById(id);
		AccountDao.closeCurrentSession();
		return book;
	}

	public void delete(String id) {
		AccountDao.openCurrentSessionwithTransaction();
		Account book = AccountDao.findById(id);
		AccountDao.delete(book);
		AccountDao.closeCurrentSessionwithTransaction();
	}

	public List<Account> findAll() {
		AccountDao.openCurrentSession();
		List<Account> books = AccountDao.findAll();
		AccountDao.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		AccountDao.openCurrentSessionwithTransaction();
		AccountDao.deleteAll();
		AccountDao.closeCurrentSessionwithTransaction();
	}

	public AccountDao bookDao() {
		return AccountDao;
	}
}
