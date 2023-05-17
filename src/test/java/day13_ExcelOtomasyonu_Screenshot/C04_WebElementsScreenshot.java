package day13_ExcelOtomasyonu_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C04_WebElementsScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        // Nutella aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // Sonuclarin Nutella icerdigini test edelim
        WebElement sonucElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualSonucYazisi= sonucElementi.getText();
        String expectedIcerik = "Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        // rapora eklenmek uzere, tum sayfanin ekran goruntusunu alalim

        ReusableMethods.tumSayfaFotografCek(driver);

        ReusableMethods.webelementFotografCek (driver,sonucElementi);
}
}
