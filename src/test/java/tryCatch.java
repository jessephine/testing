//jojojo


import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tryCatch {
    private FirefoxDriver driver;
    WebElement element;


    @Before
    public void openBrowser() throws Exception{

        System.setProperty("webdriver.gecko.driver", "/Users/jessephinelee/IdeaProjects/paralleInWeb/src/test/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void Invalid_UserCredential(){

        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("http://www.store.demoqa.com");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys("testuser_3");
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
        try{
            element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
        }catch (Exception e){
        }
        Assert.assertNull(element);
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void Valid_UserCredential()
    {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("http://www.store.demoqa.com");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys("testuser");
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
        try{
            element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
        }catch (Exception e){
        }
        Assert.assertNotNull(element);
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }


}