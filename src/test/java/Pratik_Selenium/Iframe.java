package Pratik_Selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Iframe extends TestBase{

    @Test
    public void test01() throws InterruptedException {

        // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin

        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin  // //*[@id="div-main-nav"]/div/ul/li[2]/a

        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        WebElement ourProduct=driver.findElement(By.xpath("//a[text()='Our Products']"));
        ourProduct.click();

        Thread.sleep(2000);
        //3. “Cameras product”i tiklayin

        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();
        Thread.sleep(2000);

        //4. Popup mesajini yazdirin
        Thread.sleep(2000);
        WebElement popupElementi = driver.findElement(By.className("modal-title"));
        System.out.println(popupElementi.getText());

        //System.out.println(driver.switchTo().alert().getText());

        //5. “close” butonuna basin

        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);


    }
}
