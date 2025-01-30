package de.demojfx;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper
{
    private static final String url = "jdbc:sqlite:items.db";
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private  static PreparedStatement pstmt;

    // erstellt die Tabelle, falls sie nicht existiert

    public static void intializeDatabase() {

        String sqltext = "CREATE TABLE IF NOT EXISTS product(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "description TEXT NOT NULL);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()
        ){

            stmt.execute(sqltext);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection(rs, stmt, conn, null);
        }
    }

    public static void addProduct(String name, String description) 
    {
        String sqltext = "INSERT INTO product(name, description) VALUES(?,?)";
        
        try{
             conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sqltext);
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.executeUpdate();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            
        }
    }

    public static List<Item> getAllProduct(){
        List<Item> items = new ArrayList<>();
        String sqltext = "SELECT * FROM product";

        try{
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqltext);
            while (rs.next()) {
                items.add(new Item( rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("description")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(rs, stmt, conn, null);
        }
        return items;
    }

    private static void closeConnection(ResultSet rs, Statement stmt, Connection conn, PreparedStatement pstmt) {
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt !=null){
            try{
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Statement schließen
        if (stmt != null) {
            try {
                stmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        // Verbindung zur Datenbank schließen
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Die Datenbankverbindung wurde geschlossen.");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // aktuallisiert ein exitierendes Produkt
    public static void updateProduct(int id, String name, String description){

        String sqltext = "UPDATE product SET name = ?, description = ? WHERE id = ?";

        try{
            conn = DriverManager.getConnection(url);
            pstmt = conn.prepareStatement(sqltext);
            pstmt.setString(1,name);
            pstmt.setString(2, description);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(rs,null,conn, pstmt );
        }
    }

    // löscht ein Produkt
    public static void deleteProduct(int id){
        String sqltext = "DELETE FROM product WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sqltext)
        ){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
