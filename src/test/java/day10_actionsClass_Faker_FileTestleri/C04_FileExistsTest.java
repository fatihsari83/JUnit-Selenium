package day10_actionsClass_Faker_FileTestleri;

import Pratik_Selenium.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistsTest extends TestBase {


    @Test
    public void test01(){

        // com.Team113JUnit projesi icerisinde
        // deneme.txt dosyasinin varolduğunu test edin




        String dosyYolu = "src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyYolu)));
    }
}
