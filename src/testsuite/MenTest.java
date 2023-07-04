package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
}
@Test
public void userShouldAddProductSuccessFullyToShoppingCart(){
        //Mouse Hover on Men Menu
    mouseHover(By.linkText("Men"));

    //Mouse Hover on Bottoms
    mouseHover(By.linkText("Bottoms"));

    //Click on Pants
    clickOnTheElement(By.linkText("Pants"));

    //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
    mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
    clickOnTheElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

    //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
    mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
    clickOnTheElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

    // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
    mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
    clickOnTheElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

    //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
    String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
    String actualText = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
    Assert.assertEquals("Text does not match", expectedText, actualText);

    //Click on ‘shopping cart’ Link into message
    clickOnTheElement(By.xpath("//a[contains(text(),'shopping cart')]"));

    //Verify the text ‘Shopping Cart.’
    String expectedShoppingCart = "Shopping Cart";
    String actualShoppingCart = driver.findElement(By.xpath("//span[@class='base']")).getText();
    Assert.assertEquals("Text does not match", expectedShoppingCart, actualShoppingCart);

    //Verify the product name ‘Cronus Yoga Pant’
    String expectedName = "Cronus Yoga Pant";
    String actualName = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
    Assert.assertEquals("Name does not match", expectedName, actualName);

    //Verify the product size ‘32’
    String expectedSize = "32";
    String actualSize = driver.findElement(By.xpath("//dl[@class='item-options']//dd[normalize-space()='32']")).getText();
    Assert.assertEquals("Size 32 does not match", expectedSize, actualSize);

    //Verify the product colour ‘Black’
    String expectedColour = "Black";
    String actualColour = driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
    Assert.assertEquals("Colour Black does not match", expectedColour, actualColour);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
