package settings;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;

public class Utilities {

    private static final int TIMEOUT = 5;
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Utilities.class);

    public static void printMessage(String message){
        System.out.println(message  + "soprln");
        logger.error(message);
    }

    public static void clearField(WebElement element){
        element.clear();
    }
}
