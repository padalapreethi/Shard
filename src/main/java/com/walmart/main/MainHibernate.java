/**
 * 
 */
package com.walmart.main;



import com.walmart.service.*;
import com.walmart.model.*;
import java.util.List;
/**
 * @author p0p00bj
 *
 *
 */
//This program is to test the Hibernate Working along with The implemented DAO classes : PERSISTING OF THE ACCOUNT CLASS 

public class MainHibernate {
	
	public static void main(String[] args) {
		AccountService accountservice=new AccountService();
		Account account1=new Account("Preethi","padalapreethi.nit@gmail.com","Helloworld123",1);
		Account account2=new Account("Pushkal","puushkall@gmail.com","Hihello",2);
		Account account3=new Account("Tushaar","tushaargvsg45@gmail.com","12233helllo",3);
		Account account4=new Account("Navya","navya@gmail.com","Hhmmokk",4);
		Account account5=new Account("Prasad","prasadreddy@gmail.com","haaok",5);
		
		System.out.println("=========== Persist - start ============");
		accountservice.persist(account1);
		accountservice.persist(account2);
		accountservice.persist(account3);
		accountservice.persist(account4);
		accountservice.persist(account5);
		List<Account> accounts = accountservice.findAll();
		System.out.println("=========== Books Persisted are ==========");
		for (Account a : accounts) {
			System.out.println("-" + a.toString());
		}
		System.out.println("===========Persist - end ===========");
		System.out.println("=========== Update - start ===========");
		account1.setAccountEmail("The Idiot");
		accountservice.update(account1);
		System.out.println("Book Updated is =>" +accountservice.findById(account1.getAccountID()).toString());
		System.out.println("===========Update - end ===========");
		System.out.println("===========Find - start ===========");
		long id1 = account1.getAccountID();
		Account another = accountservice.findById(id1);
		System.out.println("Book found with id " + id1 + " is =>" + another.toString());
		System.out.println("===========Find - end===========");
		System.out.println("=========== Delete - start ===========");
		long id3 = account3.getAccountID();
		accountservice.delete(id3);
		System.out.println("Deleted book with id " + id3 + ".");
		System.out.println("Now all books are " + accountservice.findAll().size() + ".");
		System.out.println("=========== Delete - end ===========");
		System.out.println("=========== FindAll - start ===========");
		List<Account> accounts2 = accountservice.findAll();
		System.out.println("Books found are :");
		for (Account b : accounts2) {
			System.out.println("-" + b.toString());
		}
		System.out.println("=========== FindAll - end ===========");
		System.out.println("=========== DeleteAll - start ===========");
		accountservice.deleteAll();
		System.out.println("Books found are now " + accountservice.findAll().size());
		System.out.println("=========== DeleteAll - end ===========");
		System.exit(0);
	}
}
