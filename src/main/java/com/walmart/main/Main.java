/**
 * 
 */
package com.walmart.main;

/**
 * @author p0p00bj
 *
 */

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.walmart.model.Account;
import com.walmart.model.Cart;
import com.walmart.model.CartItems;
import com.walmart.lib.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Account account = new Account("Preethi", "padalapreethi.nit@gmail.com", "Helloworld123", 1);
		// Cart1 consists of cartitem1 and cartitems2
		Cart cart = new Cart();
		cart.setName("MyCart1");
		cart.setId(1);
		CartItems item1 = new CartItems(10, 10, 1, cart);
		CartItems item2 = new CartItems(11, 20, 2, cart);
		Set<CartItems> itemsSet = new HashSet<CartItems>();
		itemsSet.add(item1);
		itemsSet.add(item2);

		cart.setItems(itemsSet);
		cart.setTotal(10 * 1 + 20 * 2);
		cart.setAccount(account);

		// Cart2 consists of cartitems3 and cartitems4
		Cart cart2 = new Cart();
		cart.setName("MyCart1");
		cart.setId(1);
		CartItems item3 = new CartItems(12, 10, 1, cart2);
		CartItems item4 = new CartItems(13, 20, 2, cart2);
		Set<CartItems> itemsSet2 = new HashSet<CartItems>();
		itemsSet2.add(item3);
		itemsSet2.add(item4);

		cart.setItems(itemsSet2);
		cart.setTotal(10 * 3 + 20 * 2);
		cart.setAccount(account);

		Set<Cart> carts = new HashSet<Cart>();
		carts.add(cart);
		carts.add(cart2);

		// PERSISTING OF THE OBJECTS
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// Get Session
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			// start transaction
			tx = session.beginTransaction();
			// Save the Model object
			// persisting with the root of the object provide constraints are already given
			session.save(account);
			session.save(cart2);
			session.save(cart);
			session.save(item1);
			session.save(item2);
			session.save(item3);
			session.save(item4);
			// Commit transaction
			tx.commit();
			System.out.println("Account1 ID=" + account.getAccountID());
			System.out.println("Cart1 ID=" + cart.getId());
			System.out.println("item1 ID=" + item1.getId() + ", Foreign Key Cart ID=" + item1.getCart().getId());
			System.out.println("item2 ID=" + item2.getId() + ", Foreign Key Cart ID=" + item1.getCart().getId());

		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();

			}
		}
	}

}
