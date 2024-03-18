import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
    public static void main(String[] s)
    {
WebDriver driver=new ChromeDriver();
SelectClass.driver.get("https://omayo.blogspot.com/");
driver.manage().window().maximize();
WebElement moveElement = driver.findElement(By.id("blogsmenu"));
WebElement clickElement = driver.findElement(By.xpath("//span[contains(text(),'SeleniumByArun')]"));
WebElement doubleclickElement = driver.findElement(By.xpath("//button[contains(text(),' Double click Here   ')]"));
        Actions actions = new Actions(driver);
actions.moveToElement(moveElement).perform();
actions.click(clickElement).perform();
        actions.doubleClick(doubleclickElement).perform();
driver.quit();
    }
}
