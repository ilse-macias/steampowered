package org.steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import settings.Utilities;

public class SearchPage {
    private final WebDriver driver;

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
