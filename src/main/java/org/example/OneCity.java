package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OneCity {
    public static void main(String[] args) {
        //driver launch
        System.setProperty("webdriver.chrome.driver", "C:\\chrome_drive\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // open login page, and login
        driver.get("https://visa.vfsglobal.com/blr/ru/pol/login");

        options.add_argument("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
        driver = webdriver.Chrome(options=options)


        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("mat-input-0")));
        driver.findElement(By.id("mat-input-0")).sendKeys(LoginAndPassword.LGN);
        driver.findElement(By.id("mat-input-1")).sendKeys(LoginAndPassword.PSWD);
        timer(5000L);

        //close cookie's window
        driver.findElement(By.xpath("//*[@id='onetrust-close-btn-container']/button")).click();
        timer(10000L);

        WebElement webElement = driver.findElement(By.xpath("//iframe[contains(@src, 'https://challenges.cloudflare.com/cdn-cgi/challenge-platform/h/g/turnstile/if/ov2/av0/rcv0/*')]"));
        driver.switchTo().frame(webElement);

//        driver=  driver.switchTo().frame("cf-chl-widget-o405g");


        WebElement webElement2 = driver.findElement(By.xpath("//div[@class='cb-lb']"));
        System.out.println(webElement2.getText());
        System.out.println(webElement2.getTagName());
        timer(5000L);

//        List<WebElement> webElements = driver.findElements(By.name("checkbox"));

//        for WebElement in webElements :


//        //Click Login button
//        driver.findElement(By.id("qrVk5']")).click();
//        timer(15000L);
//
//        //Click Login button
//        driver.findElement(By.xpath("//button[contains(@class,'ng-star-inserted')]")).click();
//        timer(15000L);
//
//        //click booking button
//        driver.findElement(By.xpath("//button[contains(@class,'z-index-999')]")).click();
//        timer(2000L);
//
//        //select VC
//        driver.findElement(By.xpath("//*[@id='mat-select-value-1']/span")).click();
//        driver.findElement(By.xpath("//span[contains(text(),'Poland Visa Application Center-Grodno')]")).click();
//        timer(10000L);
//
//        //select category
//        driver.findElement(By.xpath("//*[@id='mat-select-value-3']/span")).click();
//        driver.findElement(By.xpath("//span[contains(text(), ' National Visa D ')]")).click();
//        timer(10000L);
//
//
//        // loop method 100 times every 8 minutes
//        for (int i = 0; i < 100; i++) {
//            changeVisaType(driver);
//            timer(480000L);
//        }


    }


    //a method that pauses the driver
    public static void timer(Long number) {
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // change Other D-Visa to Karta Polaka
    public static void changeVisaType(WebDriver driver) {

        timer(10000L);
        driver.findElement(By.xpath("//*[@id='mat-select-value-5']/span")).click();
        timer(2000L);
        driver.findElement(By.xpath("//span[contains(text(),'Other D-visa')]")).click();
        timer(10000L);
        driver.findElement(By.xpath("//*[@id='mat-select-value-5']/span")).click();
        timer(2000L);
        driver.findElement(By.xpath("//span[contains(text(),' Karta Polaka D-visa ')]")).click();
        timer(10000L);

        // print time stamp
        String dateTime = DateTimeFormatter.ofPattern("MMM dd YYYY, hh:mm:ss a").format(LocalDateTime.now());
        System.out.print(dateTime + " ");

        // print text result
        WebElement webElement = driver.findElement(By.xpath("//div[contains(@class,'alert-info')]"));
        String textResult = webElement.getText();
        System.out.println(textResult);
    }
}


