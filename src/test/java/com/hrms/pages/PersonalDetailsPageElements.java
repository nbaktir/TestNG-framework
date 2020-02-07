package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement profileName;
	
	@FindBy(xpath = "//input[@id='photofile']")
	public WebElement chooseFilebtn;
	
	@FindBy(id ="btnSave")
	public WebElement upload;
	
	@FindBy(xpath = " //input[@id='btnAddAttachment']")
	public WebElement addAttachment;
	
	@FindBy(xpath = "//img[@id='empPic']")
	public WebElement empPic;
	
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver,this);
	}
	
}
