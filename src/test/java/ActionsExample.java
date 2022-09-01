import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ActionsExample {

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

        System.out.println("User Logged in successfully");

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://demoqa.com/profile");
        Thread.sleep(2000);

        System.out.println("Verified url is correct");

        String getUsername = driver.findElement(By.id("userName-value")).getText();

        Assert.assertEquals(getUsername, userName, "Verify username is correct");
        Thread.sleep(2000);

        System.out.println("Verified username is correct");

        boolean isLogoutBtnDisplayed = driver.findElement(By.id("submit")).isDisplayed();

        Assert.assertTrue(isLogoutBtnDisplayed, "Verify logout button is displayed");

        System.out.println("Verified logout button is displayed");

        // Click logout button
        driver.findElement(By.id("submit")).click();

        System.out.println("User logged out");

        // Quit driver
        driver.quit();

        System.out.println("Driver quit");
    }
}
