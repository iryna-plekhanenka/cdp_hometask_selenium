package com.wrpl.contendriver.catalogselection;

import com.wrpl.contentdriver.main.ContentDriverMainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class brandSelection extends ContentDriverMainClass {

    @BeforeTest(description = "Start browser and navigate to application URL")
    public void launchApplication (){
        super.driverSetUp();
        super.startBrowser();
    }

    @BeforeMethod(description = "Login")
    public void submitCredentials () {
        super.submitCredentials();
    }


 /*   @BeforeMethod(description = "Wait")
    public void waitForCountryListToBeClickable (){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement CountrySelection = driver.findElement(By.cssSelector(".selector-box-holder > .selector-box:nth-child(1)"));
        wait.until(ExpectedConditions.elementToBeClickable(CountrySelection));
        CountrySelection.click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
    }*/

    @Test(description = "Select brand")
    public void selectBrand (){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(.,'Austria')]"))));
            WebElement BrandSelection = driver.findElement(By.xpath("//mat-select[@id='mat-select-1']/div/div"));
            BrandSelection.click();
            WebElement selectedOption = driver.findElement(By.xpath("//span[contains(.,'Indesit')]"));
            selectedOption.click();
            String selectedBrand = driver.findElement(By.cssSelector(".mat-select-value-text > .ng-tns-c14-2")).getText();
            System.out.println("Brand " + selectedBrand + " is selected");
            Assert.assertEquals(selectedBrand, "Indesit");
        } catch (Exception e) {
            System.out.println("Brand selection failed.");
        }
    }

    @AfterTest(description = "Browser shut down")
     public void browserShutDown() {
            super.browserShutDown();
    }
}