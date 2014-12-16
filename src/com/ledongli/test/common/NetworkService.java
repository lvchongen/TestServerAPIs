package com.ledongli.test.common;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.ResponseHandlerInterface;


public class NetworkService {
	
	private CloseableHttpClient httpclient;
	private HttpPost httpPost;
	private CloseableHttpResponse response;
	private HttpEntity entity;
	private String result;
	private String server_IP;
	private String serverIO_IP;
	private String weiba_id;
	private String uid,uid_2;
	private String password,password_2;
	private String serverUpdate;
	

	//�ж�Staging��������Product������  serverValue=1 ΪStaging�� 2ΪProduct
	private int serverValue=2;
	
	public NetworkService(){
		httpclient = HttpClients.createDefault();
		
		setServer(serverValue);
	}
	
	private void setServer(int serverValue) {
		switch (serverValue) {
		case 1:
			server_IP="http://social.api.ledongli.cn:8090/staging/index.php";
			serverIO_IP="http://core.api.ledongli.cn/staging/io.ashx?";
			weiba_id="1000075"; //
			uid="2949163";
			password="123456";
			uid_2="2951962";
			password_2="123456";
			break;

		case 2:
			server_IP="http://social.api.ledongli.cn:8090/xq/index.php";
			serverIO_IP="http://core.api.ledongli.cn/xq/io.ashx";
			serverUpdate="http://pl.api.ledongli.cn/xq/io.ashx";
			weiba_id="1001897"; //
			uid="6736648"; //
			password="860452021016300";
			uid_2="10995534";
			password_2="359535053460293";
			break;
		
			
		//xq �ֲ�ʽ������	112.124.18.116 �� 121.40.189.40:8090
		case 3:
			server_IP="http://121.40.189.40:8090/xq/index.php";
			serverIO_IP="http://112.124.18.116/xq/io.ashx?";
			weiba_id="1001897"; //�ɿڿ���
			uid="6736648"; //�׺����
			password="359535053460293";
			uid_2="10995534";
			password_2="359535053460293";
			break;
		
		//xq �ֲ�ʽ������ 112.124.8.165
		case 4:
			server_IP="http://112.124.8.165:8090/xq/index.php";
			serverIO_IP="http://112.124.8.165/xq/io.ashx?";
			weiba_id="1001897"; //�ɿڿ���
			uid="6736648";
			password="31415926";
			uid_2="6685641";
			password_2="359535053460293";
			break;
			
		//xq �ֲ�ʽ������ 121.199.25.172	
		case 5:
			server_IP="http://121.199.25.172:8090/xq/index.php";
			serverIO_IP="http://121.199.25.172/xq/io.ashx?";
			weiba_id="1001897"; //�ɿڿ���
			uid="6736648";
			password="31415926";
			uid_2="6685641";
			password_2="359535053460293";
			break;
			
		//xq �ֲ�ʽ������	121.199.62.70
		case 6:
			server_IP="http://121.199.62.70:8090/xq/index.php";
			serverIO_IP="http://121.199.62.70/xq/io.ashx?";
			weiba_id="1001897"; //�ɿڿ���
			uid="6736648";
			password="31415926";
			uid_2="6685641";
			password_2="359535053460293";
			break;
			
		//xq �ֲ�ʽ������ 114.215.185.208	
		case 7:
			server_IP="http://114.215.185.208:8090/xq/index.php";
			serverIO_IP="http://114.215.185.208/xq/io.ashx?";
			weiba_id="1001897"; //�ɿڿ���
			uid="6736648";
			password="31415926";
			uid_2="6685641";
			password_2="359535053460293";
			break;
		
		//xq �ֲ�ʽ������ 115.29.225.238
		case 8:
			server_IP="http://115.29.225.238:8090/xq/index.php";
			serverIO_IP="http://115.29.225.238/xq/io.ashx?";
			weiba_id="1001897"; //�ɿڿ���
			uid="6736648";
			password="31415926";
			uid_2="6685641";
			password_2="359535053460293";
			break;	
		}
		
		
	}
	
	
	public String getWeiba_id() {
		return weiba_id;
	}
		
	public String getServer_IP() {
		return server_IP;
	}
	
	public String getServerIO_IP() {
		return serverIO_IP;
	}
	
	public String getUid() {
		return uid;
	}

	public String getPassword() {
		return password;
	}
	
	public String getUid_2() {
		return uid_2;
	}

	public String getPassword_2() {
		return password_2;
	}
	
	public String getUrlUpdate() {
		return serverUpdate;
	}
	
	
	//����SendPost ����
	public String sendPost(String url, List<NameValuePair> content) throws IOException{
		
		httpPost=new HttpPost(url);
		RequestConfig config=RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();
		httpPost.setConfig(config);
		httpPost.setEntity(new UrlEncodedFormEntity(content));
		try {
			response=httpclient.execute(httpPost);
			entity=response.getEntity();
			String charset = "UTF-8"; 
			result=EntityUtils.toString(entity,charset);
		} 
		catch (Exception e) {
			
			result=e.getMessage();
			
		} 	
		
		return result;
		
	}
	
	
	//����SendPostStream����
	public String sendPostStream(String url, HttpEntity entity) throws IOException{
		
		httpPost=new HttpPost(url);
		httpPost.setEntity(entity);
		try {
			response=httpclient.execute(httpPost);
			entity=response.getEntity();
			String charset = "UTF-8"; 
			result=EntityUtils.toString(entity,charset);
		} 
		catch (Exception e) {
			
			result=e.getMessage();
			
		} 	
		
		return result;
		
	}
	
	
}
