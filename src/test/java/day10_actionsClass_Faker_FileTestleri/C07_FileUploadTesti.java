package day10_actionsClass_Faker_FileTestleri;

import Pratik_Selenium.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C07_FileUploadTesti extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        /*
        drivet ile dittiğimizde bir websayfasinda
        bilgisayarimizdaki bir dosyayi upload etmek istersek

        bilgisayirimizdaki klasörlere erişmemiz gerkeir.
        Selenium webdriver bilgisayardaki dosyalara erişemez

        bunun yerine 3 adimli şu işlemleri yapariz
        1- choose file butonunu locate edelim
        2- bilgisayarınızdaki yüklemek istediğimiz dosyanin dosya yolunu olusturalim
        (mümkünde dinamik olsun)
        3- chooseButonu.sendKeys(dosyayolu) ile dosya yolunu sisteme tanıtalim

         */


        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // chooseFile butonunu kullanarak
        // projemizdeki deneme.txt dosyasini secelim.

        WebElement chooseFileButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));
        String herkesteFarkliOlan = System.getProperty("user.dir");
        String herkesteAyniOlan = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        String dosyaYolu= herkesteFarkliOlan+herkesteAyniOlan;
        chooseFileButonu.sendKeys(dosyaYolu);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUplodedElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUplodedElementi.isDisplayed());
        Thread.sleep(10000);




    }
}
