package org.steam;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.steam.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import settings.Utilities;

public class HomePage extends BasePage {

    @FindBy(id = "store_nav_search_term")
    private WebElement searchBar;

    public HomePage(WebDriver driver){
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    public void SearchAGame(String gameName){
        searchBar.sendKeys((gameName));
       Utilities.printMessage(gameName);
    //    this.waitForElementToAppear((By) searchBar);
     //   System.out.println("element found: " + gameName);
       // this.webElement(searchBar).sendKeys("Portal");
    }
}
