/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cd_collections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
/**
 *
 * @author confi
 */
public class AdminGenre {
    private Connection conn;
    private String url = "jdbc:mysql://localhost/music";
    private String username = "root";
    private String password = "nascoict1";

    public AdminGenre() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // insert genre
    public void insertGenre(Genre genre){
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO genres (genre_name) VALUES (?)")) {
            stmt.setString(1, genre.getName());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // update genre
    public void updateGenre(Genre genre) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE genres SET genre_name = ? WHERE genre_id = ?")) {
            stmt.setString(1, genre.getName());
            stmt.setInt(2, genre.getId());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // delete genre
    public void deleteGenre(Genre genre) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM genres WHERE genre_id = ?")) {
            stmt.setInt(1, genre.getId());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // get all genre
    public void getAll() {
        try (Statement stmt = conn.createStatement()) {
            String selectQuery = "SELECT * FROM genres";
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                int genreId = rs.getInt("genre_id");
                String genreName = rs.getString("genre_name");
                System.out.println(genreId + " " + genreName);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
//    public static void main(String[] args) {
//        AdminGenre admin = new AdminGenre();
//        admin.getAll();
//    }

    void deleteGenre(int genreId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

