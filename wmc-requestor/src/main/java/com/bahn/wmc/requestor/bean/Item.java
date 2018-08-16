package com.bahn.wmc.requestor.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Item {
	@SerializedName("items_in_set")
	public List<ItemsInSet> itemsInSet;
}
