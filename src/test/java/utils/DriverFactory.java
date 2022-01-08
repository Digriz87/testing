package utils;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class DriverFactory {

    private  static WebDriver driver;
    private final static String DRIVER_PATH = "src/test/resources/";

    public static WebDriver getDriver(Browser browser){
        File file;
        switch (browser){

            case IE:
                file = new File(DRIVER_PATH + "msedgedriver.exe");
                System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
                driver = new EdgeDriver();
                break;
            case CHROME:
                file = new File(DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;

        }
        driver.manage().window().maximize();
        return driver;
    }
}
