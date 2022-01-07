package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import steps.SearchSteps;

import java.io.File;

public abstract class BaseTest {

    public static WebDriver driver;

    SearchSteps steps;

    public static WebDriver getDriver() {

        return driver;
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
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
