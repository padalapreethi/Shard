/**
 * 
 */
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long id;
	
	@Column(name="total")
	private double total;
	
	@Column(name="cart_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account1;
	
	@OneToMany(mappedBy="cart1")
	private Set<CartItems> items;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<CartItems> getItems() {
		return items;
	}
	public void setItems(Set<CartItems> items) {
		this.items = items;
	}
	public Account getAccount(){
		return account1;
	}
	public void setAccount(Account acc1){
		this.account1=acc1;
	}

}
