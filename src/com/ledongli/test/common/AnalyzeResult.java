package com.ledongli.test.common;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyzeResult {
	
	private String content;
	private JSONObject jsonObject;
	
	private JSONArray jsonArray;
	
	public AnalyzeResult(String _content) {
		this.content=_content;
	}
	
	public String getValue(String parameter) {
		try {
			String finalContentString=content.substring(content.indexOf('{'));
			jsonObject=new JSONObject(finalContentString);
			int value=jsonObject.getInt(parameter);
			return String.valueOf(value);
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
	public String getUrl(String parameter) {
		try {
			String finalContentString=content.substring(content.indexOf('{'));
			jsonObject=new JSONObject(finalContentString);
			String value=jsonObject.getString(parameter);
			return value;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public JSONObject getJSON(String paramter) {
		try{
			String finalContentString=content.substring(content.indexOf('{'));
			jsonObject=new JSONObject(finalContentString);
			JSONObject object=jsonObject.getJSONObject(paramter);
			return object;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public JSONArray getJSONArray(String paramter) {
		try{
			String finalContentString=content.substring(content.indexOf('{'));
			jsonObject=new JSONObject(finalContentString);
			JSONArray array=jsonObject.getJSONArray(paramter);
			return array;
		}
		catch(Exception e){
			return null;
		}
	}
}
