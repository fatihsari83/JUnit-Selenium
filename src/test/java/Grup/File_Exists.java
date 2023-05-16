package Grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class File_Exists extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        //2. https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim

        WebElement chooseFileElementi= driver.findElement(By.id("file-upload"));

        //4. Yuklemek istediginiz dosyayi secelim.

        String dosyaYolu= "C:/Users/FATİH/Downloads/foto (2).png";
        chooseFileElementi.sendKeys(dosyaYolu);
        Thread.sleep(2000);
        //5. Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadElementi.isDisplayed());




    }
}
