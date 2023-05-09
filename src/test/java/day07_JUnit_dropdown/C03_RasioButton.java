package day07_JUnit_dropdown;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RasioButton {
   // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
   // a. Verilen web sayfasına gidin.
    //https://facebook.com
    //b. Cookies’i kabul edin
    //c. Create an account buton’una basin
    //d. Radio button elementlerini locate edin ve size uygun olani secin
    //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin


    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void radioButtonTest(){

        //a. Verilen web sayfasına gidin.

        driver.get("https://facebook.com");

        driver.findElement(By.xpath("//*[@id='u_0_0_Fi']"));

        WebElement maleButtonElementi = driver.findElement(By.xpath("(//input[@type=‘radio’])[2]"));
        WebElement femaleButtonElementi = driver.findElement(By.xpath("(//input[@type=‘radio’])[1]"));
        WebElement customButtonElementi = driver.findElement(By.xpath("(//input[@type=‘radio’])[3]"));

        maleButtonElementi.click();


        Assert.assertTrue(maleButtonElementi.isSelected());
        Assert.assertFalse(femaleButtonElementi.isSelected());
        Assert.assertFalse(customButtonElementi.isSelected());



    }
}
