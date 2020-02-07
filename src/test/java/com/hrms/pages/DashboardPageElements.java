package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	
	@FindBy(linkText = "Leave")
	public WebElement leaveLink;

	@FindBy(id="menu_pim_viewPimModule")
	public WebElement pimLink;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmployeeLink;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement empListLink;
	
	@FindBy(xpath = "//span[text()='Leave List']")
	public WebElement leaveListLink;
	
	@FindBy(id="welcome")
	public WebElement welcome;
	
	public DashboardPageElements() {  //constructor
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	//this refers to class --> this = DashboardPageElements.class
	
	public void navigateToLeaveList() {
		jsClick(leaveListLink);
	}
	
	public void navigateToAddEmployee() {
		jsClick(pimLink);
		jsClick(addEmployeeLink);
	}
}
