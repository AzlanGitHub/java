package de.demojfx;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static final String url = "jdbc:sqlite:items.db";

    // erstellt die Tabelle, falls sie nicht existiert

    public static void intializeDatabase() {

        String sqltext = "CREATE TABLE IF NOT EXISTS product(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "description TEXT NOT NULL);";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {

            stmt.execute(sqltext);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addItem(String name, String description) {
        String sqltext = "INSERT INTO product(name, description) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sqltext)
        ) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Item> getAllItems(){

        List<Item> items = new ArrayList<>();
        String sqltext = "SELECT * FROM product";

        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqltext)){
            while (rs.next()){
                items.add(new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


}
