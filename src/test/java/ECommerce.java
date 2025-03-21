import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ECommerce {
    private WebDriver driver;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup(); //Auto-download the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //Maximize Window
    }

    @Test
    public void ECommerceTest() throws InterruptedException {
        driver.get("https://ecommerce-playground.lambdatest.io/"); //Open URL
        Thread.sleep(Long.parseLong("2000"));

        // Click on "Shop by Category"
        driver.findElement(By.linkText("Shop by Category")).click();
        //Click on "MP3 Player"
        WebElement mp3Player = driver.findElement(By.xpath("//span[@class='title' and contains(text(), 'MP3 Players')]"));
        mp3Player.click();
        Thread.sleep(Long.parseLong("2000"));

       // Locate the button element
            WebElement addToCartButton = driver.findElement(By.cssSelector("button.btn-cart[title='Add to Cart']"));
            Thread.sleep(Long.parseLong("2000"));

       // Perform hover action
            Actions actions = new Actions(driver);
            actions.moveToElement(addToCartButton).perform();

       // Click on the button after hovering
            addToCartButton.click();
            System.out.println("Successfully hovered over and clicked the 'Add to Cart' button!");
        Thread.sleep(Long.parseLong("2000"));
    }
}