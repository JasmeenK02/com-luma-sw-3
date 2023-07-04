package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //Mouse Hover on Gear Menu
        mouseHover(By.xpath("//span[contains(text(),'Gear')]"));

        // Click on Bags
        clickOnTheElement(By.xpath("//span[contains(text(),'Bags')]"));


        // Click on Product Name ‘Overnight Duffle’
        clickOnTheElement(By.xpath("//a[@class='product-item-link'][normalize-space()='Overnight Duffle']"));

        //Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Overnight Duffle')]")).getText();
        Assert.assertEquals("Overnight Duffle text does not match", expectedText, actualText);


        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");

        //Click on ‘Add to Cart’ Button.
        clickOnTheElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text ‘You added Overnight Duffle to your shopping cart.
        String expectedMessageAdded = "You added Overnight Duffle to your shopping cart.";
        String actualMessageAdded = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals("Added message does not match", expectedMessageAdded, actualMessageAdded);

        //Click on ‘shopping cart’ Link into message
        clickOnTheElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Verify the product name ‘Overnight Duffle’
        String expectedName = "Overnight Duffle";
        String actualName = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")).getText();
        Assert.assertEquals("Name does not match", expectedName, actualName);

        //Verify the Qty is ‘3’
        String expectedQty = "3";
        String actualQty = driver.findElement(By.xpath("//div[@class = 'control qty']//input[@type= 'number']")).getAttribute("value");
        Assert.assertEquals("Qty '3' does not match",expectedQty, actualQty );

        //Verify the product price ‘$135.00’
        String expectedPrice = "$135.00";
        String actualPrice = driver.findElement(By.xpath("//span[contains(text(),'$135.00')]")).getText();
        Assert.assertEquals("Product price don't match",expectedPrice, actualPrice );

        //Change Qty to ‘5’
        driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/label[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/label[1]/input[1]"),"5");

        //Click on ‘Update Shopping Cart’ button
        clickOnTheElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        // Verify the product price ‘$225.00’
        String expectedUpdatedPrice = "$225.00";
        String actualUpdatedPrice = driver.findElement(By.xpath("//span[contains(text(),'$225.00')]")).getText();
        Assert.assertEquals("Updated product price do not match",expectedUpdatedPrice, actualUpdatedPrice);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
