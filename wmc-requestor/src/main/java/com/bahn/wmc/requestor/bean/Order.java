package com.bahn.wmc.requestor.bean;

import com.google.gson.annotations.SerializedName;

public class Order {

	public boolean visible;

	public String platform ;

	public int platinum;

	@SerializedName("order_type")
	public String orderType;
	
	public User user;
	
	public int quantity;
	
	@SerializedName("creation_date")
	public String creationDate;



}
