

import org.junit.Assert;
import org.junit.Test;

import static utilities.DatabaseUtilty.*;


public class JUnit_Tes {

    @Test

    public void test01(){
        createConnection();

         String sql01 = "select * from ogrenciler";
        System.out.println(getColumnData(sql01,"ogrenci_ismi"));


        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI", getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu"));

        //Assert.assertTrue(getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu"));

        Assert.assertTrue("database de kayit bulunamadi",
                getColumnData(sql01,"ogrenci_ismi").contains("Ahmet Aslan"));

        closeConnection();
    }


    @Test

    public void test02 (){

        //118 numaralı öğrenci databaede var mı?
        createConnection();
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData("select * from ogrenciler", "okul_no").contains(118));
        closeConnection();
    }



}
