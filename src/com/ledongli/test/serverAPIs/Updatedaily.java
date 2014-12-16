package com.ledongli.test.serverAPIs;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Updatedaily {
	private List<NameValuePair> updateList;
	
	private long date;
	private int score;
	private int steps;
	private double calories;
	private JSONObject report;
	private String location;
	private double lon;
	private double lat;
	private double activeValue;
	private double pm25;
	private double duration;
	private double distance;
	private JSONObject test;
	
	public JSONObject getTest() {
		return test;
	}
	public void setDuration(double duration) {
		this.duration=duration;
	}
	
	public void setDistance(double distance) {
		this.distance=distance;
	}
	
	public void setPM25(double pm25) {
		this.pm25=pm25;
	}
	
	public void setActiveVallue(double activeValue) {
		this.activeValue=activeValue;
	}
	
	public void setDate(long date) {
		this.date = date;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public void setEnergy(double calories) {
		this.calories = calories;
	}

	public void setReport(JSONObject report) {
		this.report = report;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public List<NameValuePair> getUpdateList() {
		return updateList;
	}
	
	public void setValue(String uid,String password) throws Exception {
		//updateList=new ArrayList<NameValuePair>();
		test=new JSONObject();
		test.put("action", "profile");
		test.put("cmd", "updatedaily");
		test.put("uid", uid);
		test.put("pc", password);
		
		date=System.currentTimeMillis();
		
		JSONObject stat=new JSONObject();
		stat.put("date", date);
		stat.put("score", score);
		stat.put("steps", steps);
		stat.put("calories", calories);
		stat.put("report", "[]");
		stat.put("lat", lat);
		stat.put("lon", lon);
		stat.put("activeValue", activeValue);
		stat.put("pm25", pm25);
		stat.put("duration", duration);
		stat.put("distance", distance);
		stat.put("location", location);

		if(report==null){
			stat.put("report", "[]");
		}
		else {
			stat.put("report", report);
		}
		
		JSONArray list=new JSONArray();
		
		list.put(stat);
		test.put("list", list);
//		updateList.add(new BasicNameValuePair("action", "profile"));
//		updateList.add(new BasicNameValuePair("cmd","updatedaily"));
//		updateList.add(new BasicNameValuePair("uid", uid));
//		updateList.add(new BasicNameValuePair("pc", password));
//		updateList.add(new BasicNameValuePair("list", list.toString()));
		
		//System.out.print(updateList.toString());
		
		
		
	}
}
