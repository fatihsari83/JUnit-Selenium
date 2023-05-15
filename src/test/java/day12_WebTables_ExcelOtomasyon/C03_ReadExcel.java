package day12_WebTables_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {
        // bilgisayarimizda olan bir dosyaya erişebilmek icin FileInputStream Classından onje olusturalim

        String dosyaYolu = System.getProperty("user.dir")+ "/src/test/java/day12_WebTables_ExcelOtomasyon/ulkeler.xlsx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        // projemize eklediğimiz POI kutuphanelerini kullanarak
        // class ımız icinde istenen excel in bir kopyasini olusturalim.

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row= sheet.getRow(1); // index 0'dan baslıyor
        Cell cell = row.getCell(3); // index 0'dan baslıyor

        System.out.println(cell);



    }

}
