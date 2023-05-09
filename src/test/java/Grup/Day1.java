package Grup;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day1 {

    WebDriver driver;




    //1) Bir class oluşturun: BestBuyAssertions
    @Test
    public void bestBuyMethodu(){
        mahserinDortAtlisi();
        driver.get("https://www.bestbuy.com");
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
        //asagidaki testleri yapin

        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String actualSayfaUrl = driver.getCurrentUrl();
        String expectedSayfaUrl = "https://www.bestbuy.com/";

        Assert.assertEquals(expectedSayfaUrl,actualSayfaUrl);
        //Assert.assertTrue(expectedSayfaUrl.contains(actualSayfaUrl));



    }
    @Test
    public void restBasligi(){

        //   ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        mahserinDortAtlisi();
        String actualSayfabasligi=driver.getTitle();
        String unexpectedSayfaBasligi = "Rest";

        Assert.assertFalse(actualSayfabasligi.contains(unexpectedSayfaBasligi));


    }



    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    public void mahserinDortAtlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



    }
}
