import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {



        //1) Driver tanimla
        Class.forName("org.postgresql.Driver");

        //2) Database 'e baglan
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
        "3535Ozlem."
        );

        //3) Statement
        Statement st = con.createStatement();


        //4) ResultSet
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //5) datalari al
    while (veri.next()){
        System.out.println(veri.getInt(1)
        + veri.getString(2)
        + veri.getString(3)
        + veri.getString (4));
    }

    //6) baglanti kapt

    con.close();
    st.close();
    veri.close();


      /*  JDBS: Java DataBase Conectivity

        Database'den data cekmeye yariyor

        Classs.forName(); Driver tanimlamak icin kullanilir

        JDBC; Driver manager vasitasi ile bizi database yonlendiriyor

        Driver: Bu arayuz veritabani sunucusu ile olan iletisimi idare eder

        Connection Bu arayuz bir veritabani ile iletisim kurmak icin tum ...

        ResultSet: JDBS kullanrak veri cekme islemi sonrasinda veri listelemek icin ResultSet sinifi kullanilir.

        Database e full erisim vermek risklidir genelde sinirli yetkiler verilir

        Genelde select komutu ile calisilir

        Veriler uzerinde dolasmak ici genelde, next,first, previous absolute gibi methodlar kullanilir

        Pom xml dosyasi ne ise yarar: Projenin kalbidir
        bizim icin onemli olan yer properties ve project arasindaki kod blogudur. Oraya komutlarimizi tanimliyoruz. or fr bilmiyorsak
        oraya tanimladigimizdda artik konusabiliriz

*Ilk satira tanimlanacak lan sey driver'dri

        executeQuery() ile database e ileti yolluyoruz daha sonra biz bu veriyi while dongu kullanrak datalara ulasip onlari yazdirabiliyoruz */

    }
}
