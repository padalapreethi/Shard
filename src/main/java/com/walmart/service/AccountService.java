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

	public Account findById(long id) {
		AccountDao.openCurrentSession();
		Account account = AccountDao.findById(id);
		AccountDao.closeCurrentSession();
		return account;
	}

	public void delete(long id) {
		AccountDao.openCurrentSessionwithTransaction();
		Account account = AccountDao.findById(id);
		AccountDao.delete(account);
		AccountDao.closeCurrentSessionwithTransaction();
	}

	public List<Account> findAll() {
		AccountDao.openCurrentSession();
		List<Account> accounts = AccountDao.findAll();
		AccountDao.closeCurrentSession();
		return accounts;
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
