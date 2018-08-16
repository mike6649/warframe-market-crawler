package com.bahn.wmc.requestor.bean;

import com.google.gson.annotations.SerializedName;

public class ItemDescription {
	@SerializedName("wiki_link")
	public String wikiLink;
	
	@SerializedName("item_name")
	public String itemName;
	
	@SerializedName("url_name")
	public String url_name;

}
