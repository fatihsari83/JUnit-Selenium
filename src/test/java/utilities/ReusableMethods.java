package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReusableMethods {

    public static void tumSayfaFotografCek(WebDriver driver)  {

        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt= LocalDateTime.now();
        String tarihEtiketi = "TumSayfa"+ldt.getYear()+ ldt.getMonthValue()
                            +ldt.getDayOfMonth()+ldt.getHour()
                            +ldt.getMinute()+ldt.getSecond()+".png";
        String path = "target/ekranResimleri/"+ tarihEtiketi;

        File tumSayfaFotograf = new File(path);

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciResim,tumSayfaFotograf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void webelementFotografCek(WebDriver driver, WebElement webElementi) throws IOException {

        LocalDateTime ldt= LocalDateTime.now();
        String tarihEtiketi = "WebElementi"+ldt.getYear()+ ldt.getMonth()
                +ldt.getDayOfMonth()+ldt.getHour()
                +ldt.getMinute()+ldt.getSecond()+".png";
        String path = "target/ekranResimleri/"+ tarihEtiketi;

        File tumSayfaFotograf = new File(path);

        File geciciResim = webElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfaFotograf);
    }
}
