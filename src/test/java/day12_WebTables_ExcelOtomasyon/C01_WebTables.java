package day12_WebTables_ExcelOtomasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1."https://www.amazon.com" adresine gidin

        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin

        Actions action = new Actions(driver);
        action.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin

        Thread.sleep(2000);
        WebElement tumBodyElementi= driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());
        // tum body yi tek element olarak locate etmek
        // body icinde gecen bir metnin varlıgını test etmek gibi gorevler ıcın kullanilabilir

        //4.Web table’daki satir sayisinin 9 oldugunu test edin

        List <WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi=9;
        int actualSatirSayisi = satirElementleriList.size();

        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);


        //5.Tum satirlari yazdirin

        System.out.println("====================");
        for (WebElement eachSatir: satirElementleriList
             ) {
            System.out.println(eachSatir.getText());
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin

        List <WebElement> birinciSatirDatalari= driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSurunSayisi =13;
        int actualSutunSayis= birinciSatirDatalari.size();
        Assert.assertEquals(expectedSurunSayisi,actualSutunSayis);

        //7. 5.sutunu yazdirin
        System.out.println("--------------------");
        List <WebElement> besinciSutunElementleri= driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachData:besinciSutunElementleri
             ) {
            System.out.println(eachData.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren
        //bir method olusturun
        System.out.println("/-/-/-/-/-/-/-");
        System.out.println(dataGetir(3,5));

    }
    private  String dataGetir (int satirNo, int sutunNo){

        //tbody/tr[5]/td[9]
        String dinamikXpath="//tbody/tr["+satirNo+"]/td["+sutunNo+"]";

        WebElement istenenDataElementi= driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }

}
