import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "3535Ozlem.");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from ogrenciler");

        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Sütun Sayısı: " + rsmd.getColumnCount());
        System.out.println("1. sutunun ismi: " + rsmd.getColumnName(1));
        System.out.println("2. sutunun ismi: " +rsmd.getColumnName(2));
        System.out.println("3. sutunun ismi: " +rsmd.getColumnName(3));
        System.out.println("4. sutunun ismi: " +rsmd.getColumnName(4));

        System.out.println("tablo ismi = " + rsmd.getTableName(1));



    }
}
