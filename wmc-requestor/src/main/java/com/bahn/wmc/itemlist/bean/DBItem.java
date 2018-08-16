package com.bahn.wmc.itemlist.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.bahn.wmc.requestor.bean.ItemDescription;

public class DBItem {
	@SerializedName("_id")
	public String id;
	
	@SerializedName("url_name")
	public String urlName;
	
	public List<String> tags;
	
	public String icon;
	
	public String thumb;
	
	@SerializedName("en")
	public ItemDescription enDescription;
	
	
}
