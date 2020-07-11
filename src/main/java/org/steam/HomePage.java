package org.steam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.TestBase;

public class HomePage extends TestBase {
    @FindBy(id = "store_nav_search_term")
    private WebElement searchBar;

    public HomePage(){

    }

    public void SearchAGame(){

    }
}
