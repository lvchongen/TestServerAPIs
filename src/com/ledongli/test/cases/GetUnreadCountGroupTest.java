package com.ledongli.test.cases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetUnreadCount_group;

public class GetUnreadCountGroupTest {

	private NetworkService networkService;
	private String url;
	private GetUnreadCount_group count_group;

	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		count_group=new GetUnreadCount_group();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		count_group=null;
	}

	@Test
	public void test() {
		
		try {
			String result=networkService.sendPost(url, count_group.getUnreadCount());
			boolean value=result.contains("\"status\":1") && result.contains("unread_comment") && result.contains("new_applicant_count");
			assertTrue(value);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
