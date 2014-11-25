package com.ledongli.test.cases;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.AddUser;
import com.ledongli.test.serverAPIs.Addfriends;
import com.ledongli.test.serverAPIs.Atmelist;
import com.ledongli.test.serverAPIs.Commentlist;
import com.ledongli.test.serverAPIs.DeleteNotify;
import com.ledongli.test.serverAPIs.DoDelete;
import com.ledongli.test.serverAPIs.DoDeleteSession;
import com.ledongli.test.serverAPIs.DoInBox;
import com.ledongli.test.serverAPIs.DoPost;
import com.ledongli.test.serverAPIs.DoPostGroup;
import com.ledongli.test.serverAPIs.DoReplay;
import com.ledongli.test.serverAPIs.DoSetIsRead;
import com.ledongli.test.serverAPIs.Findfriend;
import com.ledongli.test.serverAPIs.GetInfo;
import com.ledongli.test.serverAPIs.GetMessageByListId;
import com.ledongli.test.serverAPIs.GetNotifyList_Notify;
import com.ledongli.test.serverAPIs.GetUnreadCount_Message;
import com.ledongli.test.serverAPIs.GetUnreadCount_Notify;
import com.ledongli.test.serverAPIs.GetUnreadList;
import com.ledongli.test.serverAPIs.Getnotify;
import com.ledongli.test.serverAPIs.Getuserlimitedinfo;
import com.ledongli.test.serverAPIs.ListFriends;
import com.ledongli.test.serverAPIs.Listfans;
import com.ledongli.test.serverAPIs.Rankfriends;
import com.ledongli.test.serverAPIs.Ranknear;
import com.ledongli.test.serverAPIs.SetRead;
import com.ledongli.test.serverAPIs.Uadd;
import com.ledongli.test.serverAPIs.User_Following;
import com.ledongli.test.serverAPIs.User_Friends;
import com.ledongli.test.serverAPIs.User_applicant;


public class Temp {
	public static void main(String args[]) throws Exception {
		
		NetworkService networkService=new NetworkService();
		
		String url=networkService.getServer_staging();
		
//		long unixTime = System.currentTimeMillis() / 1000L;
//		String unixTimeString=String.valueOf(unixTime);
//		
//		
//		
//		Ranknear test=new Ranknear(Double.valueOf(unixTimeString));
		
		DoPost test=new DoPost();
		
		//test.setIdsString("2783");
		
		
		String result=networkService.sendPost(url, test.getDoPost());
		
		System.out.print(result);
	}
}
