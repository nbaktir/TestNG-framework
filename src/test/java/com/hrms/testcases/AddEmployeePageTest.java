package com.hrms.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

/*Step1: navigate to the application
Step2: login into application
Step3: navigate to add employee page
Step4: add employee by providing firstname, middle name, last name
Step5: verify employee has been added successfully
*/

public class AddEmployeePageTest extends CommonMethods {

	@Test(groups = "regression")
	public void addEmployeeValidation() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dasboard = new DashboardPageElements();
		AddEmployeePageElements addEmployee = new AddEmployeePageElements();
		
		test.info("Login in into HRMS");
		login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
		
		dasboard.navigateToAddEmployee();
		
		test.info("Adding employee");
		addEmployee.addEmployee("Ali", "Ahmet");
		sendText(addEmployee.mName, "Mehmet");
		
		jsClick(addEmployee.saveBtn);
		
		test.info("Validating the added employee");
		String expectedName= "Ali Mehmet Ahmet";
		String actualName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		Assert.assertEquals(actualName,expectedName,"Name does NOT match");
	}
	
	
	@DataProvider(name = "addEmployee")
	public Object[][] getDataFromExcel(){
		Object[][] data = ConfigsReader.readXL(Constants.XL_FILE_PATH,"AddEmployee");
		return data;
	}
	
	@Test(dataProvider = "addEmployee", groups="regression")
	public void addEmpWithDataProvider(String fName, String lName) {
		
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dasboard = new DashboardPageElements();
		AddEmployeePageElements addEmployee = new AddEmployeePageElements();
		PersonalDetailsPageElements pd = new PersonalDetailsPageElements();
	
		test.info("Login in into HRMS");
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		test.info("Navigating to Add Employee Page");
		dasboard.navigateToAddEmployee();
		
		test.info("Adding employee");
		addEmployee.addEmployee(fName, lName);
		click(addEmployee.saveBtn);
		
		test.info("Validating employee is added");
		Assert.assertEquals(pd.profileName.getText(), fName+" "+lName, "Name does NOT match");
	}
	
}












