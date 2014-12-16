package com.ledongli.test.cases;

import static org.junit.Assert.*;

import org.apache.http.HttpRequest;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.HttpTool;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Updatedaily;

public class UpdatedailyTest {
	
	private NetworkService networkService;
	private String url;
	private Updatedaily updatedaily;
	private String uid, password;
	

	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getUrlUpdate();
		uid=networkService.getUid();
		password=networkService.getPassword();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		updatedaily=null;
	}
	
	//测试上传成功， 且数据库正确更新
	@Test
	public void test() {
		try {
			updatedaily=new Updatedaily();
			
			//设置测试数据
			long date=System.currentTimeMillis();
			int score=1000;
			int steps=1200;
			int energy=320;
			JSONObject report=null;
			double lat=39.97529930838477;
			double lon=116.3507434554603;
			String location="北京";
			double pm25=1.1;
			double distance=1000;
			double duration=2000;
			double activeValue=500;
					
			
			//传测试数据
			updatedaily.setDate(date);
			updatedaily.setScore(score);
			updatedaily.setSteps(steps);
			updatedaily.setEnergy(energy);
			updatedaily.setReport(report);
			updatedaily.setLat(lat);
			updatedaily.setLon(lon);
			updatedaily.setLocation(location);
			updatedaily.setPM25(pm25);
			updatedaily.setDistance(distance);
			updatedaily.setDuration(duration);
			updatedaily.setActiveVallue(activeValue);
			
			updatedaily.setValue(uid, password);
			
			//String result=networkService.sendPost(url, updatedaily.getUpdateList())
			//String result=HttpTool.sendGet(url, updatedaily.getUpdateList().toString());
			//System.out.print(output);
			
			HttpTool httpTool=new HttpTool();
			//System.out.print(updatedaily.getList().toString());
			String result=httpTool.sendGet(url, updatedaily.getTest().toString());
			//System.out.print(updatedaily.getTest().toString());
			//String result=networkService.sendPost(url, updatedaily.getList().toString());
			//System.out.print(result);
			
			
			
			
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
