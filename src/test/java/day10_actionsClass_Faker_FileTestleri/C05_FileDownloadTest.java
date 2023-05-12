package day10_actionsClass_Faker_FileTestleri;

import Pratik_Selenium.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //foto.png
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. foto.png dosyasını indirelim
        WebElement fotoElementi = driver.findElement(By.linkText("foto.png"));
        fotoElementi.click();
        Thread.sleep(3000);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosyayi download klasörüne indirir

        String dosyaYolu = "C:/Users/FATİH/Downloads/foto.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
    }


}
