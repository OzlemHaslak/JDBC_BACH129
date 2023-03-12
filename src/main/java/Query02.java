import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
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

    // soru 1 : region id'si 1 olan 'country name' degerlerinir cagirin

       // String sql01 = "select country_name from country where region_id = 1";
        String sql01= "select country_name from countries where region_id=1";

        //4) resulset

        ResultSet veri = st.executeQuery(sql01);

        while (veri.next())
         {
            System.out.println(veri.getString(1));
        }

        //Soru 2 :Region id'nin 2 den buyuk oldugu "country id" ve "country name" degerlerini cagirin


        String sql02 = "select country_id, country_name from countries where region_id >2";

        ResultSet veri02 = st.executeQuery(sql02);

        while (veri02.next()){
            System.out.println(veri02.getString("country_id")+ veri02.getString("country_name"));
        }



        //6) baglanti kapt

        con.close();
        st.close();
        veri.close();
        veri02.close();

    }
    }

