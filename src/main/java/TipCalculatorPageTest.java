import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TipCalculatorPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qatipcalc.ccbp.tech/");

        WebElement billAmount = driver.findElement(By.cssSelector("input[id^='billAmount']"));
        billAmount.sendKeys("1000");

        WebElement percentage = driver.findElement(By.cssSelector("input[id^='percentageTip']"));
        percentage.sendKeys("12");

        WebElement calculateButton = driver.findElement(By.cssSelector("button[class*='calculate']"));
        calculateButton.click();

        WebElement tipAmounteEl = driver.findElement(By.cssSelector("p[id*='tip']"));
        String actualTipAmount = tipAmounteEl.getText();


        WebElement totalAmounteEl = driver.findElement(By.cssSelector("p[id*='total']"));
        String actualTotalAmountEl = totalAmounteEl.getText();

        if(actualTipAmount.equals("120.00") && actualTotalAmountEl.equals("1120.00")){
            System.out.println("Tip Calculated Correctly");
        }
        else{
            System.out.println("Tip Calculated Incorrectly");
        }
        percentage.clear();
        calculateButton.click();

        WebElement errorMsg = driver.findElement(By.cssSelector("p[class^='error-message']"));
        String acutalErrorMsg = errorMsg.getText();

        if(acutalErrorMsg.equals("Please Enter a Valid Input")){
            System.out.println("Error message displayed for no input");
        }
        else{
            System.out.println("Error message missing for no input");
        }

        percentage.sendKeys("10f");
        calculateButton.click();

        WebElement invaildMsg = driver.findElement(By.cssSelector("p[id $= 'Message']"));
        String actualInvaildMsg = invaildMsg.getText();

        if(actualInvaildMsg.equals("Please Enter a Valid Input")){
            System.out.println("Error message displayed for invalid input");
        }
        else{
            System.out.println("Error message missing for invalid input");
        }



    }
}