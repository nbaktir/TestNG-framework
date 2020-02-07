package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LeaveListPageTest extends CommonMethods{

	@Test(groups = "regression")
	public void leaveLabelValidation() {
		
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();
		
		test.info("Loggin into the application");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password,ConfigsReader.getProperty("password"));
		
		click(login.loginBtn);
		test.info("Navigating to the Leave List");
		jsClick(dashboard.leaveListLink);
		test.info("Validating Leave List Label");
		Assert.assertTrue(leaveList.leaveListText.isDisplayed(),"Label is NOT displayed");
	
	}
	
	@Test(groups="regression")
	public void leaveLableValidation1(){
		
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToLeaveList();
		
		Assert.assertTrue(leaveList.leaveListText.isDisplayed(),"Label is NOT displayed");
	
	}
	
}
