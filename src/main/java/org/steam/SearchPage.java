package org.steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.Utilities;

public class SearchPage {
    private final WebDriver driver;

    @FindBy (css = "#search_resultsRows > a:nth-child(1) > div.col.search_capsule > img")
    private WebElement selectAGame;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnTheGame(){
        selectAGame.click();
        Utilities.printMessage("Game clicked.");
    }

}
