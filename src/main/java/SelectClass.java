import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static pages.Locators.*;

public class SelectClass {
public static WebDriver driver;
  public static void main(String s[])
  {
      WebDriver driver = new ChromeDriver();

//      we are initializing the browser using selenium manager
       driver = new ChromeDriver() ;
      driver.get("https://omayo.blogspot. com/");
//      Select class
      Select dropdownMenu = new Select(driver.findElement(dropdown));
      dropdownMenu.selectByIndex(2);
//      Approach 1
      WebElement selectedOption = dropdownMenu.getFirstSelectedOption();
      String selectedText = selectedOption.getText();
      System.out.println("Value of the Index: " + selectedText);
//      Approach 2
      String selectedText1 = driver.findElement(dropdownValue(3)).getText();
      System.out.println("Again value of the index with second approach" + selectedText1);
      System.out.println("Selected multiple values " + dropdownMenu.isMultiple());

//      Multiple Dropdown value
      Select dropdown2 = new Select(driver.findElement(By.cssSelector("#multiselect1")));
      if(dropdown2.isMultiple()) {
          dropdown2.selectByValue("volvox");
          dropdown2.selectByValue("swiftx");
      }
      System.out.println("VALUE"+ dropdown2.getFirstSelectedOption().getText());


      List<WebElement> listofAllValues= new ArrayList<>();
      listofAllValues= dropdown2.getAllSelectedOptions();
      for(WebElement i :listofAllValues)
      {
          System.out.println("Values ="+ i.getText());
      }
  }


}
