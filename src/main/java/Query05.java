import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "3535Ozlem.");

        Statement st = con.createStatement();

 //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K')

      //  int s1 = st.executeUpdate("insert into ogrenciler values(312, 'Sena Can', 12, 'K')");
      //  System.out.println("bir satir eklendi = " + s1);

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
// (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

    /*    String [] veri = { "insert into ogrenciler values(600, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(601, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(602, 'Sena Can', 12, 'K')"};

        //1.yol


        int count = 0;
        for (String w : veri) {
            st.execute(w);
            count++
        }
        System.out.println(count + " satır eklendi");  */

        //2. yol

        String [] veri = { "insert into ogrenciler values(700, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(701, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(702, 'Sena Can', 12, 'K')"};

        for ( String w : veri){
            st.addBatch(w); // yukaridaki datalarin hepsini birlestiriyor
        }
            st.executeBatch(); // datalari tek seferde  gonderiyor
    }
}
