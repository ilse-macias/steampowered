package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    private static final int TIMEOUT = 5;
    private static WebDriver driver;

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void waitTime(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clearField(WebElement element){
        element.clear();
    }
}
