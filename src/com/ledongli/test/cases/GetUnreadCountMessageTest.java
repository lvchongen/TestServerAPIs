package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetUnreadCount_Message;

public class GetUnreadCountMessageTest {
	
	GetUnreadCount_Message getUnreadCount_Message;
	NetworkService networkService;
	String url;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		getUnreadCount_Message=new GetUnreadCount_Message();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		getUnreadCount_Message=null;
	}

	@Test
	public void test() {
		try {
			String actualString=networkService.sendPost(url, getUnreadCount_Message.getUnReadCount());
			System.out.print(actualString);
			boolean result1=actualString.contains("unread_comment");
			boolean result2=actualString.contains(("new_applicant_count"));
			boolean result=result1&&result2;
			assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
