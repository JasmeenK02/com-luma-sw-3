package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on the element.
     */
    public void clickOnTheElement(By by){
        driver.findElement(by).click();
    }
    /**
     * This method will get text from the element.
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    /**
     * This method will send text to the element.
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will mouse hover the element.
     */
    public void mouseHover(By by){

        WebElement text1 = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(text1).build().perform();

    }
    public void mouseHoverAndClick(By by, String text){

        WebElement text1 = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(text1).click().build().perform();

    }

    public void visibleTextDropDown(By by,String text){
        WebElement dropDown = driver.findElement(by);
        Select select= new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void valueDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
    public void indexDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }


}
