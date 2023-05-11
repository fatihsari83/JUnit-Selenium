package day09_switcHingWindow_actionsClass;

import Pratik_Selenium.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C03_ActionsClass2 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);

        actions.contextClick(ciziliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi= "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        // linki tıkladığimizda yeni window


        String ilkWindowwhd = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // ikinci sayfa biz newWindow() demeden acildiğinda
        // ikinci window un WHD java kullanarak bulmalıyız

        String ikinciwindowWHD= "";
        Set<String> windowHDegerleriSeti =driver.getWindowHandles();
        // ilkwindowWHD

        for (String eachWHD:windowHDegerleriSeti
             ) {
            if (!eachWHD.equals(ilkWindowwhd)){
                ikinciwindowWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciwindowWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String expectedYazi= "Elemental Selenium";
        WebElement yaziElementi= driver.findElement(By.tagName("h1"));
        String actualYazi= yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        Thread.sleep(5000);
    }

}
