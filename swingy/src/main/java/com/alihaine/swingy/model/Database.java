package com.alihaine.swingy.model;

import com.alihaine.swingy.controller.hero.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public static Database db = new Database();
    private Connection conn = null;

    private Database() {
        try {
            String url = "jdbc:mysql://localhost:3310/data";
            String user = "root";
            String password = "pass";

            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Database fatal error");
            System.exit(5);
        }
    }

    public void UpdateData(Hero hero) {
        String updateQuery = "UPDATE users SET name = ?, champ = ?, level = ?, experience = ?, attack = ?, defense = ?, hitpoint = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(updateQuery);

            stmt.setString(1, hero.getName());
            stmt.setString(2, hero.getChamp());
            stmt.setInt(3, hero.getLevel());
            stmt.setInt(4, hero.getExperience());
            stmt.setInt(5, hero.getAttack());
            stmt.setInt(6, hero.getDefense());
            stmt.setInt(7, hero.getHitPoint());
            stmt.setInt(8, hero.getId());

            stmt.executeUpdate();
            System.out.println("Database save");
        } catch (SQLException e) {
            System.out.println("Database fatal error");
            System.exit(5);
        }
    }

    public void AddData(Hero hero) {
        String sql = "INSERT INTO users (name, champ, level, experience, attack, defense, hitpoint) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hero.getName());
            ps.setString(2, hero.getChamp());
            ps.setInt(3, hero.getLevel());
            ps.setInt(4, hero.getExperience());
            ps.setInt(5, hero.getAttack());
            ps.setInt(6, hero.getDefense());
            ps.setInt(7, hero.getHitPoint());

            ps.executeUpdate();
            System.out.println("Database save");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int GetLastId() {
        String sql = "SELECT MAX(id) FROM users;";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Database fatal error");
            System.exit(5);
        }
        return 0;
    }

    public List<String> GetDatabaseRow(int id) {
        String sql = "SELECT * FROM users WHERE id=" + id;
        List<String> values = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                values = new ArrayList<>();

                values.add(String.valueOf(rs.getInt("id")));
                values.add(rs.getString("name"));
                values.add(rs.getString("champ"));
                values.add(String.valueOf(rs.getInt("level")));
                values.add(String.valueOf(rs.getInt("experience")));
                values.add(String.valueOf(rs.getInt("attack")));
                values.add(String.valueOf(rs.getInt("defense")));
                values.add(String.valueOf(rs.getInt("hitpoint")));
            }
        } catch (SQLException e) {
            System.out.println("Database fatal error");
            System.exit(5);
        }
        return values;
    }
}
