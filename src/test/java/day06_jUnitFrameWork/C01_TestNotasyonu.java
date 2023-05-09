package day06_jUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {


    WebDriver driver;

    /*
        Bu class icerisinde 3 test çalıştıralım.
        1- google anasayfaya gidelim, url in google icerdiğinini test edin
        2- wisequarter anasayfaya gidip url in wisequarter icerdiğini test edin
        3- amazon anasayfaya gidip amazon logosunun göründügünü test edin
     */


    /*
        Junit in bize sağladığı ilk ve belki de en önemli özellik
        test methodların bagımsız olarak çalıştırılabilmesini sağlayan
        @Test notasyonudur.
     */
    @Test
    public void googleTest(){
        System.out.println("google test");

    }
    @Test @Ignore ()
    public void wiseTest (){
        System.out.println("wise test");

    }
    @Test
    public void amazonTest (){

        driver.get("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        System.out.println("amazon test");

    }
    public void mahserinDortAtlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }



}
