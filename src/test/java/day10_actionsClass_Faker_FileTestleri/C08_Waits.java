package day10_actionsClass_Faker_FileTestleri;

import Pratik_Selenium.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Waits extends TestBase {

    @Test
    public void test01(){

        // implicity wait in rolünü görebilmek icin
        // baslangic ayarlarini bu testte methodunda yapalim
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        //4. Remove butonuna basin.
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //6. Add buttonuna basin
        //7. It’s back mesajinin gorundugunu test edin


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazona gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.

        driver.findElement(By.xpath("//button[text()='Remove']")).click();


        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement goneElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));

        //6. Add buttonuna basin
        //7. It’s back mesajinin gorundugunu test edin

        Assert.assertTrue(goneElementi.isDisplayed());

    }

}
