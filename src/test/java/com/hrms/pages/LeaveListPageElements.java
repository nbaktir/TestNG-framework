package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.hrms.testbase.BaseClass;

public class LeaveListPageElements {

	@FindBy(css="a.toggle.tiptip")
	public WebElement leaveListText;
	
	public LeaveListPageElements(){   //constructor
		PageFactory.initElements(BaseClass.driver, this);
		// this --> LeaveListPageElements.class
	}
}
