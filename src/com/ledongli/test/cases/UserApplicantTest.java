package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.User_applicant;

public class UserApplicantTest {
	
	NetworkService networkService;
	String url;
	User_applicant user_applicant;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		user_applicant=new User_applicant();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		user_applicant=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, user_applicant.getUser_application());
			boolean value=result.contains("\"status\":1");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
