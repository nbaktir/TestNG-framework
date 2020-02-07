package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods{

	@FindBy(id="firstName")
	public WebElement fName;
	
	@FindBy(id="middleName")
	public WebElement mName;
	
	@FindBy(id="lastName")
	public WebElement lName;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	@FindBy(id = "chkLogin")
	public WebElement checkBox;
	
	@FindBy(xpath = "//input[@id='photofile']")
	public WebElement chooseFilebtn;
	
	public AddEmployeePageElements() {   //constructor
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void addEmployee(String first, String last) {
		sendText(fName, first);
		sendText(lName, last);
	}
}
