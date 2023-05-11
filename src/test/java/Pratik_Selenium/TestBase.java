package Pratik_Selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestBase extends utilities.TestBase {
    /*
    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
2) sayfadaki iframe sayısını bulunuz.
3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
4) ilk iframe'den çıkıp ana sayfaya dönünüz
5) ikinci iframe'deki (Jmeter Made Easy) linke
(https://www.guru99.com/live-selenium-project.html) tıklayınız
     */

    @Test
    public void test01() throws InterruptedException {

        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz

        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.


        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        //WebElement iframeElementi= driver.findElement(By.linkText("https://www.youtube.com/embed/RbSlW8jZFe8"));
       // driver.switchTo().frame(iframeElementi);
       // iframeElementi.click();
                //driver.findElement(By.linkText("https://www.youtube.com/embed/RbSlW8jZFe8")).click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        Thread.sleep(3000);
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke

        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();






    }

}
