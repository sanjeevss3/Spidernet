package com.hybridFramework.loginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

/**
*
*@author Sanjeev Chaudhary
*https://github.com/sanjeevss3/
*
*/

public class LoginTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test
	public void testLoginToApplication(){
		System.out.println("It is login page.");
		log.info(LoginTest.class.getName()+" started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(config.getUserName(), config.getPassword());
		boolean status = loginPage.verifySuccessLoginMsg();
		if(status){
		   log.info("login is sucessful");	
		}
		else{
			Assert.assertTrue(false, "login is not sucessful");
		}
	}

}
