package com.bahn.wmc.itemlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.bahn.wmc.requestor.ItemsBean.WmcItemsBean;
import com.bahn.wmc.requestor.bean.ItemDescription;
import com.google.gson.Gson;

public class ItemListReader {
	
	private Reader getRequest(URL url) throws Exception {
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setConnectTimeout(10000);
		con.setReadTimeout(10000);

		int status = 0;
		try {
			status = con.getResponseCode();
		} catch (Exception e){
			throw new Exception ("Failed to get response from " + url.toString());
		}
		
		if (status != 200){
			throw new Exception ("HTTP Request to " + url.toString() + " returned status: " + status);
		}
		
		System.out.println("Successfully retrieved item list from: " + url.toString());
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()),1000 * 8192);
		
		return in;
	}
	
	public Map<String,String> getItemList() throws Exception {
		
		Gson gson = new Gson();
		WmcItemsBean bean = new Gson().fromJson(getRequest(new URL("https://api.warframe.market/v1/items")), WmcItemsBean.class);
		Map <String,String> map = new HashMap<String,String>();
		for (ItemDescription item : bean.payload.items.en) {
			map.put(item.itemName.toLowerCase(), item.url_name);
		}
		
		return map;
	}
	

	public static void main (String[] args){
		try {
			ItemListReader r = new ItemListReader();
			Map<String,String> map = r.getItemList();
			for (String str : map.keySet()){
				System.out.println(str + "\t" + map.get(str));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
