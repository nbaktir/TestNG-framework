package com.hrms.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class LoginPageTest extends CommonMethods {

	@Test(groups = "smoke", enabled = false)
	public void login() {

		LoginPage login = new LoginPage();
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");
		click(login.loginBtn);
	}

	@Test(groups = "regression",enabled = false)
	public void loginEmptyPw() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, "Admin");

		click(login.loginBtn);
		waitForVisibilty(login.errorMsg);

		String expectedError = "Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expectedError, "Message does NOT match the expected");
	}
	
	//login with getting data from property file 
	@Test(enabled = false)
	public void loginValidation() {
		
		String user = ConfigsReader.getProperty("username");
		String psw = ConfigsReader.getProperty("password");
		
		LoginPageElements login = new LoginPageElements();
		
//		login.sendText(login.username, user);
//		login.sendText(login.password, psw);
//		click(login.loginBtn);
		
		login.login(user, psw);
		
		DashboardPageElements dashboard = new DashboardPageElements();
		Assert.assertTrue(dashboard.welcome.isDisplayed(),"Login failed");
	}
	

	@DataProvider(name = "login")
	public Object[][] getDataFromExcel() {

		Object[][] data = ConfigsReader.readXL(Constants.XL_FILE_PATH, "Login");
		return data;
	}
	
	@Test(dataProvider = "login", enabled = false)
	public void loginWithDataProvider(String username, String password) {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		login.login(username, password);
		Assert.assertTrue(dashboard.welcome.isDisplayed(), "Login failed");
	}
	
	
	@Test(dataProvider = "getData")
	public void multipleLogin(String uid, String psw) {
		LoginPageElements login = new LoginPageElements();
		
		login.login(uid, psw);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		return ExcelUtility.excelIntoArray(Constants.HRMS_XL_FILE_PATH,"Login");
	}
}
