package com.wrpl.contentdriver.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ContentDriverMainClass {

    public static final String START_URL = "http://10.2.25.10:9081/content-driver/login";
    public static final String PASSWORD = "IRYNA";
    public static final String LOGIN = "IRYNA";
    public WebDriver driver;

    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iryna_Plekhanenka\\Desktop\\chromedriver_win32\\chromedriver.exe");//MOVE FROM LOCAL DIR TO REPO!!!!!!
        driver = new ChromeDriver(); //launch new chrome instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("The setup process is completed");

    }

    public void startBrowser() {
        driver.get(START_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void submitCredentials() {
        //locate login and password fields
        WebElement usernameElement = driver.findElement(By.name("username"));
        usernameElement.clear();
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.clear();
        usernameElement.sendKeys(LOGIN);
        passwordElement.sendKeys(PASSWORD);
        //submit creds
        WebElement submitButton = driver.findElement(By.xpath("//button"));
        submitButton.click();
    }

    public void browserShutDown() {
        driver.close();
    }

}


