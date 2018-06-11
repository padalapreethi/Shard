package com.walmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author padala preethi
 *
 */

@Entity
@Table(name="CART_ITEMS")	
public class CartItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="item_total")
	private double itemTotal;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private float price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="offer")
	private boolean offer;
	
	@Column(name="sellerDetails")
	private String SellerDetails ;
	
	@ManyToOne
	@JoinColumn(name="cart_id", nullable=false)
	private Cart cart1;
	
	//constructors for the Class: CartItems
	public CartItems(){}
	
	public CartItems(long itemId, double total, int qty, Cart c){
		this.id=itemId;
		this.itemTotal=total;
		this.quantity=qty;
		this.cart1=c;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice(){
		return price;
	}
	public void setPrice(float Price){
		 this.price=Price;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String desc){
		this.description=desc;
	}
	public boolean getOfferDetails(){
		return offer;
	}
	public void setOfferDetails(boolean off){
		this.offer=off;
	}
	public String getSellerDetails(){
		return SellerDetails;
	}
	public void setSellerDetails(String det){
		this.SellerDetails=det;
	}
	public Cart getCart() {
		return cart1;
	}
	public void setCart(Cart cart) {
		this.cart1 = cart;
	}
	

}
