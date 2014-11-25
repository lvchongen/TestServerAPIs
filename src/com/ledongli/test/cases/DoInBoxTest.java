package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoInBox;

public class DoInBoxTest {
	
	private String url;
	private NetworkService networkService;
	private DoInBox doInBox;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		doInBox=new DoInBox();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doInBox=null;
	}

	@Test
	public void test() {
		try {
			String actualString=networkService.sendPost(url, doInBox.getDoInBox());
			if(actualString!=null) {
				System.out.print(actualString);
				boolean result1=actualString.contains("list_id");
				boolean result2=actualString.contains("member_uid");
				boolean result=result1&&result2;
				assertTrue(result);
			}
			if(actualString==null)
				assertTrue(true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
