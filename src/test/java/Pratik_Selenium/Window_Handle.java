package Pratik_Selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class Window_Handle extends TestBase{

    @Test
    public void test01() throws InterruptedException {

        // 1."http://webdriveruniversity.com/" adresine gidin

        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin

        Actions actions = new Actions(driver);
        WebElement loginPortalElementi = driver.findElement(By.xpath("(//div[@class='section-title'])[2]"));
        actions.scrollToElement(loginPortalElementi);

        String ilkSayfaWHD = driver.getWindowHandle();

        //3."Login Portal" a tiklayin

        driver.findElement(By.xpath("(//div[@class='section-title'])[2]")).click();

        //4.Diger window'a gecin

        Set<String> whdegerleriSet= driver.getWindowHandles();
        String ikinciWindowWHD="";

        for (String eachWhd: whdegerleriSet
        ) {
            if (!eachWhd.equals(ilkSayfaWHD)){
                ikinciWindowWHD= eachWhd;
            }
        }

        //5."username" ve "password" kutularina deger yazdirin

        driver.switchTo().window(ikinciWindowWHD);

        WebElement userNameElementi = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userNameElementi.click();
        userNameElementi.sendKeys("Merhaba");

        WebElement passwordElementi= driver.findElement(By.id("password"));
        passwordElementi.click();
        passwordElementi.sendKeys("123456");

        Thread.sleep(2000);
        //6."login" butonuna basin

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        driver.switchTo().alert();

        String expectedPopup = "validation failed";
        String actualPopup = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedPopup,actualPopup);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun

        driver.switchTo().window(ilkSayfaWHD);
        Thread.sleep(2000);

        //10.Ilk sayfaya donuldugunu test edin

        String expectedilkSayfa= "http://webdriveruniversity.com/";
        String actualilkSayfa = driver.getCurrentUrl();

        Assert.assertEquals(expectedilkSayfa,actualilkSayfa);
        Thread.sleep(2000);



    }
}
