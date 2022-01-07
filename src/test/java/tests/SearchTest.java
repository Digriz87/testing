package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultPage;


public class SearchTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComInChromeTest (String text) throws InterruptedException{
        SearchPage searchPage = new SearchPage();

        searchPage.fillSearchField(text);
        searchPage.pressEnter();
        Thread.sleep(3000);
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.assertThatTopResultContainsText("Пишем автотест с использованием Selenium Webdriver ...");
        searchResultPage.assertThatTopResultContainsProperAttributeText("LC20lb MBeuO DKV0Md");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"selenium java"}, {"selenium javascript"}};
    }
}
