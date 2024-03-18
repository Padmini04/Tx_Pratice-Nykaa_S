package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locators {

public static By dropdown = By.cssSelector(".combobox");
public static By dropdownValue (int index)
{
    return By.xpath("//select[@id='drop1']//option["+index+"]");
}
}
