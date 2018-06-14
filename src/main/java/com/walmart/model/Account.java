package com.walmart.model;

/**
 * @author p0p00bj
 *
 */

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private long account_id;
	
	@Column(name="account_name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="account_pass")
	private String password;
	
	@OneToMany(mappedBy="account1")
	private Set<Cart> cart;
	
	public Account(){}
	
	public Account(String account_name, String account_email, String account_password, long account_id){
		this.name=account_name;
		this.email=account_email;
		this.password=account_password;
		this.account_id=account_id;
	}
	public String getAccountName() {
		return name;
	}
	public void setAccountName(String account_name) {
		this.name= account_name;
	}
	public String getAccountEmail() {
		return email;
	}
	public void setAccountEmail(String account_email) {
		this.email=account_email;
	}
	public String getAccountPassword() {
		return password;
	}
	public void setAccountPassword(String account_password) {
		this.password= account_password;
	}
	public long getAccountID() {
		return account_id;
	}
	public void setAccountID(long id) {
		this.account_id = id;
	}
	
	}


