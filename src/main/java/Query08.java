import pojos.Doctor;
import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query08 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "3535Ozlem.");

        Statement st = con.createStatement();

        // Doktors tablosunu olusturun

        // String sql01 = "create table doctors(id int, isim varchar(30), bolum varchar(20), ucret int)";
        // st.execute(sql01);

        // Pojo class kullanarak tabloya data ekleyiniz

        List<Doctor> kayitlar = new ArrayList<>();
        kayitlar.add(new Doctor(20, "ali can", "dahiliye", 500));
        kayitlar.add(new Doctor(21, "Ali Can", "Dahiliye", 600));
        kayitlar.add(new Doctor(22, "Ali Can", "Dahiliye", 500));
        kayitlar.add(new Doctor(23, "Ali Can", "Dahiliye", 800));
        kayitlar.add(new Doctor(24, "Ali Can", "KBB", 400));
        kayitlar.add(new Doctor(25, "Ali Can", "Dahiliye", 500));
        kayitlar.add(new Doctor(26, "Ali Can", "Psikoloji", 500));
        kayitlar.add(new Doctor(27, "Ali Can", "Dahiliye", 200));
        kayitlar.add(new Doctor(28, "Ali Can", "Dahiliye", 300));
        kayitlar.add(new Doctor(29, "Ali Can", "Cildiye", 500));

        // Cok miktarda data eklemek icin PreparedStatment kullanmaliyiz

        PreparedStatement tablo = con.prepareStatement("insert into doctors values (?,?,?,?)");

        for (Doctor each : kayitlar) {
            tablo.setInt(1, each.getId());  // id : 20
            tablo.setString(2, each.getIsim()); // isim  : ali can
            tablo.setString(3, each.getBolum());  // bolum dahiliye
            tablo.setDouble(4, each.getUcret());  // ucret

            tablo.addBatch();  // butun datalari birlestiriyor

        }
        tablo.executeBatch();

        con.close();
        tablo.close();
    }
}
