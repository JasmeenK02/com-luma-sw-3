package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException{
        //Mouse Hover on Women Menu
       // mouseHover(By.xpath("//span[contains(text(),'Women')]"));
        mouseHover(By.linkText("Women"));
        Thread.sleep(2000);
        //Mouse Hover on Tops
        mouseHover(By.xpath("//a[@id='ui-id-9']"));
        // Click on Jackets
        clickOnTheElement(By.xpath("//a[@id='ui-id-11']"));
        //Select Sort By filter “Product Name”
        visibleTextDropDown(By.xpath("//select[@id='sorter']"), "Product Name");
        //Verify the products name display in alphabetical order
        List<WebElement> productsAToZ = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement e : productsAToZ){
            System.out.println(e.getText());
        }

    }
    @Test
    public void verifyTheSortByPriceFilter(){
        //Mouse Hover on Women Menu
        mouseHover(By.linkText("Women"));

        //Mouse Hover on Tops
        mouseHover(By.linkText("Tops"));

        //Click on Jackets
        mouseHover(By.linkText("Jackets"));

        //Select Sort By filter “Price"
        visibleTextDropDown(By.xpath("//select[@id='sorter']"), "Price");

        //Verify the products price display in Low to High
        List<WebElement> priceLowToHigh = driver.findElements(By.xpath("//span[@data-price-type= 'finalPrice']"));
        for (WebElement e : priceLowToHigh) {
            System.out.println(e.getText());
        }
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
