package com.walmart.service;

import java.util.List;

import com.walmart.dao.CartDao;
import com.walmart.model.Cart;

public class CartService {
	private static CartDao CartDao;

	public CartService() {
		CartDao = new CartDao();
	}

	public void persist(Cart entity) {
		CartDao.openCurrentSessionwithTransaction();
		CartDao.persist(entity);
		CartDao.closeCurrentSessionwithTransaction();
	}

	public void update(Cart entity) {
		CartDao.openCurrentSessionwithTransaction();
		CartDao.update(entity);
		CartDao.closeCurrentSessionwithTransaction();
	}

	public Cart findById(long id) {
		CartDao.openCurrentSession();
		Cart cart = CartDao.findById(id);
		CartDao.closeCurrentSession();
		return cart;
	}

	public void delete(long id) {
		CartDao.openCurrentSessionwithTransaction();
		Cart cart = CartDao.findById(id);
		CartDao.delete(cart);
		CartDao.closeCurrentSessionwithTransaction();
	}

	public List<Cart> findAll() {
		CartDao.openCurrentSession();
		List<Cart> carts = CartDao.findAll();
		CartDao.closeCurrentSession();
		return carts;
	}

	public void deleteAll() {
		CartDao.openCurrentSessionwithTransaction();
		CartDao.deleteAll();
		CartDao.closeCurrentSessionwithTransaction();
	}

	public CartDao CartDao() {
		return CartDao;
	}

}
