package com.wrpl.contentdriver.login;

import com.wrpl.contentdriver.main.ContentDriverMainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class loginWithValidCredentials extends ContentDriverMainClass {


    @BeforeTest(description = "Start browser and navigate to application URL")
    public void launchApplication (){
        super.driverSetUp();
        super.startBrowser();
    }

    @Test(description = "Login to application with valid credentials")
    public void loginToApplication () {
         super.submitCredentials();
         WebElement searchField = driver.findElement(By.xpath("//span[text()='SEARCH']"));
         if (searchField.getSize() != null){
             System.out.println("Test passed.");
         }else{
             System.out.println("Test failed.");
         }

    }

    @AfterTest(description = "Browser shut down")
            public void browserShutDown () {
                super.browserShutDown();
            }

    }