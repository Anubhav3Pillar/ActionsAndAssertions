import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ActionsSelectExample {

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
        driver.navigate().to("https://demoqa.com/select-menu");

        // Select Class
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));

        SoftAssert softAssert = new SoftAssert();

        System.out.println("SoftAssert created");

        System.out.println("SoftAssert different options");

        softAssert.assertEquals(select.getFirstSelectedOption(), "White");

        select.selectByIndex(2);
        Thread.sleep(2000);

        softAssert.assertEquals(select.getFirstSelectedOption(), "Green");

        select.selectByValue("10");
        Thread.sleep(2000);

        softAssert.assertEquals(select.getFirstSelectedOption(), "Aqua");

        select.selectByVisibleText("Voilet");
        Thread.sleep(2000);

        softAssert.assertEquals(select.getFirstSelectedOption(), "Voilet");

        softAssert.assertAll();

        System.out.println("Asserted all");

        // Quit driver
        driver.quit();

        System.out.println("Driver quit");
    }
}
