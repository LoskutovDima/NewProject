package ru.otus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BasePageTest {
    protected WebDriver driver;

    @Before
    public void setDriver(){
        WebDriverManager.chromedriver().setup();


    }

    @After
    public void driverEnd() {
        if(driver!=null)
            driver.quit();

    }
}
