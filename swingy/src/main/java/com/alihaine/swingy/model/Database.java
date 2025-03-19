package com.alihaine.swingy.model;

import com.alihaine.swingy.controller.hero.Hero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    public static Database db = new Database();
    private Connection conn = null;

    private Database() {
        try {
            String url = "jdbc:mysql://localhost:3310/data";  // Replace "data" with your actual database name
            String user = "root";
            String password = "pass";

            // Establishing the connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    public void UpdateData(Hero hero) {
        String updateQuery = "UPDATE users SET name = ?, champ = ?, level = ?, experience = ?, attack = ?, defense = ?, hitpoint = ? WHERE id = ?";

        // Prepare statement
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(updateQuery);

            // Set values for the query
            stmt.setString(1, hero.getName());
            stmt.setString(2, hero.getChamp());
            stmt.setInt(3, hero.getLevel());
            stmt.setInt(4, hero.getExperience());
            stmt.setInt(5, hero.getAttack());
            stmt.setInt(6, hero.getDefense());
            stmt.setInt(7, hero.getHitPoint());
            stmt.setInt(8, hero.getId());  // Assuming you want to update the row with id = 1

            // Execute the update
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddData(Hero hero) {
        String sql = "INSERT INTO users (name, champ, level, experience, attack, defense, hitpoint) VALUES ('Test', 'Fizz', 0, 0, 0, 0, 0)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
