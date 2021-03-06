package com.skilldistillery.midterm.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "credit_card_num")
	private String creditCardNum;
	@Column(name = "credit_card_exp_date")
	private Date creditCardExpDate;
	@Column(name = "credit_card_ccv")
	private String creditCardCcv;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToMany(mappedBy = "buyer")
	private List<Purchase> purchases;
	private int active;
	
	
	
	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void addPurchase(Purchase purchase) {
		if(purchases == null) {
			purchases = new ArrayList<>();
		}
		if(! purchases.contains(purchase)) {
			purchases.add(purchase);
		}
		purchase.setBuyer(this);
	}
	
	public void removePurchase(Purchase purchase) {
		purchase.setBuyer(null);
		if(purchases != null) {
			purchases.remove(purchase);
		}
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreditCardNum() {
		return creditCardNum;
	}
	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}
	public Date getCreditCardExpDate() {
		return creditCardExpDate;
	}
	public void setCreditCardExpDate(Date creditCardExpDate) {
		this.creditCardExpDate = creditCardExpDate;
	}
	public String getCreditCardCcv() {
		return creditCardCcv;
	}
	public void setCreditCardCcv(String creditCardCcv) {
		this.creditCardCcv = creditCardCcv;
	}
	
	
	public Buyer(int id, String creditCardNum, Date creditCardExpDate, String creditCardCcv, User user) {
		super();
		this.id = id;
		this.creditCardNum = creditCardNum;
		this.creditCardExpDate = creditCardExpDate;
		this.creditCardCcv = creditCardCcv;
		this.user = user;
	}
	
	public Buyer(String creditCardNum) {
		super();
		this.creditCardNum = creditCardNum;
	}

	public Buyer() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buyer [id=");
		builder.append(id);
		builder.append(", creditCardNum=");
		builder.append(creditCardNum);
		builder.append(", creditCardExpDate=");
		builder.append(creditCardExpDate);
		builder.append(", creditCardCcv=");
		builder.append(creditCardCcv);
		builder.append(", user=");
		builder.append(user);
		
		if (purchases != null) {
		builder.append(", purchases=");
		builder.append(purchases.size());
		}
		
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buyer other = (Buyer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
