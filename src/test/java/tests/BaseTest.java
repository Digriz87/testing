package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactory;

import java.io.File;

public abstract class BaseTest {

    public static WebDriver driver;

    SearchSteps steps;

    public static WebDriver getDriver() {

        return driver;
    }

    @BeforeClass
    public void setUp()  {

        driver = DriverFactory.getDriver(Browser.IE);
        driver.get("https://www.google.com/");
        steps = new SearchSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"selenium java"}, {"selenium javascript"}};
    }

}
