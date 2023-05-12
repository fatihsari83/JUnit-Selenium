package day10_actionsClass_Faker_FileTestleri;

import Pratik_Selenium.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_dosya_YolunuDinamikYapma extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        System.out.println(System.getProperty("user.dir"));
        //C:\Users\FATİH\IdeaProjects\com.Team113JUnit

        System.out.println(System.getProperty("user.home"));
        //C:\Users\FATİH

        // biz downloada indirdiğim dosyanin dosya yolunu 2'ye böleceğiz
        // /User/FATİH                     /Downloads/foto.png
        // herkesin bilgisayarinda farklı   herkeste ayni
        // System.getProperty("user.home)   /Downloads/foto.png



        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluherkesteAyniOlanKisim = "/Downloads/foto.png";

        String dosyaYolu = dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        dosyaYoluDegisenKisim = System.getProperty("user.dir");

    }}
