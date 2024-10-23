package com.usta.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/veterinariapoo"; // Cambia por el nombre de tu base de datos
    private static final String USER = "root"; // Usuario por defecto de XAMPP
    private static final String PASSWORD = ""; // Contraseña por defecto es vacía

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
