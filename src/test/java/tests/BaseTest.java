package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import steps.SearchSteps;
import utils.DriverFactory;
import utils.PropertyReader;


public abstract class BaseTest {

    public static WebDriver driver;

    SearchSteps steps;

    public static WebDriver getDriver() {

        return driver;
    }

    @BeforeClass
    public void setUp()  {

        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.get(PropertyReader.getUrl());
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
