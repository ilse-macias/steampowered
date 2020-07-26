package org.steam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    @FindBy (css = "#search_resultsRows > a:nth-child(1) > div.col.search_capsule > img")
    private WebElement selectGame;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnTheGame(){
        String gameName = "Portal 2";

        selectGame.click();
        Assert.assertEquals(gameName, "Portal 2");
    }

}
