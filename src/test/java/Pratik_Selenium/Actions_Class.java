package Pratik_Selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_Class extends TestBase{


    @Test
    public void test01() throws InterruptedException {

        // 1. "http://webdriveruniversity.com/Actions" sayfasina gidin

        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin

        Actions actions = new Actions(driver);
        WebElement meFirtstElementi = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(meFirtstElementi).perform();

        //3. "Link 1" e tiklayin

        WebElement linkBirElementi = driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        linkBirElementi.click();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        // WebElement iFrameyaziElementi= driver.findElement(By.tagName("a"));
       // Assert.assertTrue(iFrameyaziElementi.isDisplayed());
       // System.out.println(iFrameyaziElementi.getText());
        Thread.sleep(2000);
        //5. Popup'i tamam diyerek kapatin

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //6. "Click and hold" kutusuna basili tutun

        WebElement holdElementi = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
       holdElementi.click();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        Actions actions1 = new Actions(driver);
        WebElement clickElementi = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions1.clickAndHold(clickElementi).perform();
        System.out.println(clickElementi.getText());


        //8. "Double click me" butonunu cift tiklayin

        Actions actions2 = new Actions(driver);
        WebElement doubleClickMeElementi = driver.findElement(By.id("double-click"));
        actions2.doubleClick(doubleClickMeElementi).perform();
        Thread.sleep(2000);



    }
}
