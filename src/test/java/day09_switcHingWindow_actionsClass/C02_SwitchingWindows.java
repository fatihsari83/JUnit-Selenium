package day09_switcHingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        /*
            driver.switchTo().newWindow() kullanarak actiğimiz
            window a driver otomatik olarak gecer.


            ANCAKKKKK......
            bir link tikladiğimizda biz newWindow() methodunu kullanmadan
            bir link tıkladiğimizda yeni window açılıyorsa
            driver eski windowda kalir
            Yeni windowa driver i gecirmek icin
            yeni windowun WindowHandleDegerine ihtiyacimiz var
         */

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        WebElement openingYaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi= "Opening a new window";
        String actualYazi= openingYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        String ilkSayfaWHD= driver.getWindowHandle();

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle= "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Click Here butonuna basın.

        driver.findElement(By.xpath("//*[text() = 'Click Here']")).click();


        Set <String> whdegerleriSet= driver.getWindowHandles();
        String ikinciWindowWHD="";

        for (String eachWhd: whdegerleriSet
             ) {
            if (!eachWhd.equals(ilkSayfaWHD)){
                ikinciWindowWHD= eachWhd;
            }
        }
        // Artık acilan 2.window un windowHandleDegerine sahibiz

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciWindowWHD);
        System.out.println(driver.getTitle());



        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement newWindowyaziElementi= driver.findElement(By.tagName("h3"));
        expectedYazi= "New Window";
        actualYazi= newWindowyaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);



    }

    //● https://the-internet.herokuapp.com/windows adresine gidin.

    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
}
