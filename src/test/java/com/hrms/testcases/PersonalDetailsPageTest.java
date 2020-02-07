package com.hrms.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.EmployeeListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

// i want to open existing employee detail page and add photo
// open employee list 
// find employee and click
// choose photo and upload
public class PersonalDetailsPageTest extends CommonMethods{

	@Test
	public void uploadPhoto() throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
	
		DashboardPageElements dasboard = new DashboardPageElements();
		click(dasboard.pimLink);
		
		click(dasboard.empListLink);
	
		EmployeeListPageElements emplist = new EmployeeListPageElements();
		PersonalDetailsPageElements personalDet = new PersonalDetailsPageElements();
		
		
		boolean found = false;
		
		while(!found) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			if(!found) {
				for(int i =1; i<rows.size();i++) {
					String rowText = rows.get(i-1).getText();
					if(rowText.contains("Amanda Brown")) {
						jsClick(driver.findElement(By.xpath("//a[contains(text(),'Amanda')]")));
						found = true;
						Thread.sleep(4000);
						break;
					}
				}
			}else {
				click(emplist.next);
			}	
			
		}
		personalDet.empPic.click();
		personalDet.chooseFilebtn.sendKeys("/Users/NY/Desktop/download.png");
		
		personalDet.upload.click();
		
		Thread.sleep(3000);
	}
}
