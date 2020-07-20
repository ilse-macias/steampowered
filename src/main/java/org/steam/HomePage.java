package org.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import settings.Utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private final WebDriver driver;

    @FindBy(id = "store_nav_search_term")
    private WebElement searchBar;

    @FindBy(css = "#store_search_link > img")
    private WebElement searchIcon;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchGame(String gameName) {
        searchBar.sendKeys((gameName));
        Utilities.printMessage(gameName);

        WebElement listGame = driver.findElement(By.id("searchterm_options"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("searchterm_options")));
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
}
