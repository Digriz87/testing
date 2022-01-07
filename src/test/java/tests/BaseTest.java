package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;

public abstract class BaseTest {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null){
            File file = new File("src/test/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();

        }
        return driver;
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
       driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void goBack(){
        driver.navigate().back();
    }


}
