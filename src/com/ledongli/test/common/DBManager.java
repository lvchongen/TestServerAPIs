package com.ledongli.test.common;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.omg.CORBA.PRIVATE_MEMBER;

public class DBManager {
	
	private String url_staging="";
	private String url_product="";
	private String userName_staging="";
	private String passWord_stagingString="";
	private String userName_product="";
	private String passWord_product="";
	
	public String getUrl_staging() {
		return url_staging;
	}
	public void setUrl_staging(String url_staging) {
		this.url_staging = url_staging;
	}
	public String getUrl_product() {
		return url_product;
	}
	public void setUrl_product(String url_product) {
		this.url_product = url_product;
	}
	
	public String getUserName_staging() {
		return userName_staging;
	}
	public void setUserName_staging(String userName_staging) {
		this.userName_staging = userName_staging;
	}
	public String getPassWord_stagingString() {
		return passWord_stagingString;
	}
	public void setPassWord_stagingString(String passWord_stagingString) {
		this.passWord_stagingString = passWord_stagingString;
	}
	public String getUserName_product() {
		return userName_product;
	}
	public void setUserName_product(String userName_product) {
		this.userName_product = userName_product;
	}
	public String getPassWord_product() {
		return passWord_product;
	}
	public void setPassWord_product(String passWord_product) {
		this.passWord_product = passWord_product;
	}
	
	
	public void connectDB(String url, String userName, String passWord, String sql) {
		
		Connection connection=null;
		java.sql.Statement statement=null;
		ResultSet resultSet=null;
		
		try{
			connection=DriverManager.getConnection(url, userName, passWord);
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
		}
		
		catch(Exception ex) {
			return;
		}
		finally {
			try {
				if(connection!=null)
					connection.close();
				if(statement!=null)
					statement.close();
				if(resultSet!=null)
					resultSet.close();
			}
			catch(Exception e) {
				return;
			}
		}
		
	}
	
	
	
	
	
}
