package day11_seleniumWait_WebTables;

import Pratik_Selenium.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_SeleniumWaits {

    /*
        otomasyon yaparken ve web elementlerin bulunmasi icin gerekli süreyi
        implicitywait ile ayarlariz

        Implicity wait sayfanin yuklenmesi ve
        her bir webelementin bulunmasi icin tanimlanan
        max. bekleme süresidir.
        her islem icin sıfırdan baslar ve max süre doluncaya kadar görevi tamamlamaya
        çalıisir.
        max süre icerisinde görev tamamlanamazsa
        exception verip çalışmayı durdurur.

        Testlerin buyuk cogunlugunda implicity wait süresi
        sebkranizasyonu sağlamak icin yeterli olur.

        ANCAK
        ozel bir görev icin
     */


// 2. Iki tane metod olusturun : implicitWait() , explicitWait()
//  Iki metod icin de asagidaki adimlari test edin.
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//4. Remove butonuna basin.
//5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
//6. Add buttonuna basin
//7. It’s back mesajinin gorundugunu test edin

    @Test
    public void test01() {
        // implicitly wait'in rolunu gorebilmek icin
        // baslangic ayarlarini bu test method'unda yapalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin

        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin

        WebElement backMesajElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(backMesajElementi.isDisplayed());
        driver.close();
    }


    @Test
    public void explicitlyWaitTesti(){

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.

        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        /*
            Burada testi manuel olarak yapip
            bir karar vermemiz gerekiyor
            1- test etmek istediğimiz webelement zaten görünüyorsa
                webelementi locaye yapip sonra ozel beklemeyi tanımlarim
            2- test etmek istediğimiz elementin ulaşılabilir olmasi icin
                beklemek gerekiyorsa
                locator i verip bu locarot ile bir element locate edene kadar
                    expection fırlatma bekle diyebiliriz
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement itsGoneElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin

        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();


        //7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        driver.close();


    }
}