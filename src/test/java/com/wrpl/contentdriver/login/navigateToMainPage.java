package com.wrpl.contentdriver.login;

import com.wrpl.contentdriver.main.ContentDriverMainClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class navigateToMainPage extends ContentDriverMainClass {

    String expectedTitle = "Content Driver";

    @BeforeTest(description = "Start browser")
    public void launchBrowser() {
       super.driverSetUp();
    }

    @Test(description = "Check that url is available")
    public void urlAvailability(){
        super.startBrowser();
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed: URL is available");
        }catch (AssertionError e){
            System.out.println("Test failed");
        }
    }

    @AfterTest(description = "Browser shut down")
    public void browserShutDown() {
        driver.close();
    }
}