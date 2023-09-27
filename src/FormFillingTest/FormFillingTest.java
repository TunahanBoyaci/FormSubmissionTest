package FormFillingTest;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class FormFillingTest extends ParameterDriver {
    @Test
    public void test(){
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");

        WebElement inputButton = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputButton.click();

        WebElement ajaxButton = driver.findElement(By.xpath("//li[@class=\"tree-branch\"]//ul//li//a[text()='Ajax Form Submit']"));
        ajaxButton.click();

        WebElement nameInbox = driver.findElement(By.cssSelector("input[id=\"title\"]"));
        nameInbox.sendKeys(MyMethods.generateRandomFirstName());

        WebElement textInbox = driver.findElement(By.cssSelector("textarea[id=\"description\"]"));
        textInbox.sendKeys(MyMethods.generateRandomEmail());

        WebElement subButton = driver.findElement(By.cssSelector("input[id=\"btn-submit\"]"));
        subButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div[id=\"submit-control\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[id=\"submit-control\"]"),"Form submited Successfully!"));
        successMessage.isDisplayed();
        Assert.assertTrue(successMessage.getText().contains("Successfully"));

    }
}
