package day09_switcHingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {

    // gerekli ayarlamalari yapip
    // amazon anasayfaya gidin
    // title nin amazon kelimesi içerdiğini test edin
    // yeni bir tab acarakwisequarter anasayfaya gidin
    // url in wisequarter içerdiğini test edin
    /*

        eger görevimizde yeni windowa gittikten sonra
        windowlara arasi gecis islemi varsa
        üzerinde calistiğimiz windowlarin
        windowHandleDegerlerini alip kaydetmekte fayda var.
     */

    @Test
    public void test01() throws InterruptedException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();

        // title nin amazon kelimesi içerdiğini test edin
        String expectedIcerik= "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        // yeni bir tab acarakwisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);
        driver.get("https://www.wisequarter.com");
        String ikinciSayfaWindow= driver.getWindowHandle();

        // url in wisequarter içerdiğini test edin
        expectedIcerik= "wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // tekrar amazon un acık oldugu sayfaya gecin
        // ve url nin amazon icerdiğini test edin

        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        expectedIcerik= "amazon";
        actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Thread.sleep(3000);


    }
}
