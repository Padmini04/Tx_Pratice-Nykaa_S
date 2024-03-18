import com.sun.source.tree.PackageTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //WebElement on which drag and drop operation needs to be performed
        WebElement dragElement = driver.findElement(By.xpath("//*[@id='credit2']"));
        WebElement dropElement = driver.findElement(By.xpath("//*[@id='bank']/li"));
        Actions ele = new Actions(driver);
        //Building a drag and drop action
        Action dragAndDrop = ele.clickAndHold(dragElement)
                .moveToElement(dropElement)
                .release(dropElement)
                .build();
        dragAndDrop.perform();
//        ele.dragAndDrop(dragElement,dropElement).build().perform();
//        Action dragAndDrop = builder.clickAndHold(fromElement)



    }
}
