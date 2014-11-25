package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Commentlist;

public class CommonlistTest {
	
	NetworkService networkService;
	String url;
	Commentlist commentlist;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		commentlist=new Commentlist();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		commentlist=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, commentlist.getCommentList());
			boolean value=result.contains("\"status\":");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
