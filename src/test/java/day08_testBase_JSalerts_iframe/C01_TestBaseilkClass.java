package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_TestBaseilkClass extends TestBase {

    @Test
    public void test01(){
        // amazon a gidelim

        driver.get("https://www.amazon.com");

        // nutella icin arama yapalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuclarinin Nutella icerdiğini test edelim

        String expectedIcerik= "Nutella";
        String actualAramaSonuYazisi= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        Assert.assertTrue(actualAramaSonuYazisi.contains(expectedIcerik));
    }
}
