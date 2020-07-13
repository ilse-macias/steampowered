package org.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import settings.Utilities;

public class HomePage {

    private final WebDriver driver;

    @FindBy(id = "store_nav_search_term")
    private WebElement searchBar;

    @FindBy(css = "#store_search_link > img")
    //(id = "store_search_link")
    private WebElement searchIcon;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchAGame(String gameName) {
        searchBar.sendKeys((gameName));
        Utilities.printMessage(gameName);
    }

    public void clickonSearchIcon(){
        searchIcon.click();
        Utilities.printMessage("Button clicked.");
    }

    public void clearGame(String gameName){
        searchBar.clear();
        searchBar.sendKeys(gameName);
        Utilities.printMessage(gameName);
    }

    //This module maybe will be delete.
    public void listGame(){
        WebElement listDropDownList =
                driver.findElement(By.id("search_suggestion_contentssearch_suggestion_contents"));
        Utilities.printMessage("Fundiona");
        Utilities.waitTime(listDropDownList);
        Utilities.printMessage("Fundiona");
    }
}
