package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComInChromeTest (String text) throws InterruptedException {

       steps.executeSearchByKeyword(text)
               .verifyThatTopResultContainsCorrectText("Пишем автотест с использованием Selenium Webdriver ...")
               .verifyThatTopResultContainsProperAttributeText("LC20lb MBeuO DKV0Md");


    }


}
