import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ActionsComplexExample {

    public static void main(String[] args) throws InterruptedException {

        String userName = "testuser2022";

        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Opening the browser with URL
        driver.get("https://demoqa.com/login");

        // Enter username
        driver.findElement(By.id("userName")).sendKeys(userName);
        Thread.sleep(2000);

        // Enter password
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
        Thread.sleep(2000);

        // Click Login button
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        System.out.println("User logged in");

        // Navigate Actions
        driver.navigate().to("https://demoqa.com/droppable");

        System.out.println("Verify drag drop action");

        Actions dragDrop = new Actions(driver);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));

        Thread.sleep(2000);
        dragDrop.dragAndDrop(dragElement, dropElement).build().perform();
        Thread.sleep(2000);

        System.out.println("Drag-Drop completed");

        String text = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']/p")).getText();

        Assert.assertEquals(text, "Dropped!");
        Thread.sleep(2000);

        System.out.println("Verified text is correct");

        // Quit driver
        driver.quit();

        System.out.println("Driver quit");
    }
}
