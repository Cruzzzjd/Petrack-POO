package com.usta.models.CuidadorU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.usta.utils.ConnectionManager;
import com.usta.utils.GenericDAO;

public class CuidadorUImplDAO implements GenericDAO<CuidadorU> {


    private Connection connection;
        public CuidadorUImplDAO() {
        this.connection = ConnectionManager.getInstance().getConnection();
    }


    public boolean validarCuidadorU(String username, String password) {
        String query = "SELECT * FROM cuidadoru WHERE username = ? AND password = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
       pstmt.setString(1, username);
       pstmt.setString(2, password);
       
       ResultSet rs = pstmt.executeQuery();
       return rs.next(); // Si hay resultados, el cuidador es válido
   } catch (Exception e) {
       e.printStackTrace();
       return false;
   }
   
    }

    

  

    @Override
    public void add(CuidadorU obj) throws SQLException {

        String query = "INSERT INTO cuidadoru (username,password) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, obj.getUsername());
            stmt.setString(2, obj.getPassword());
            stmt.executeUpdate();
        }

    }

    @Override
      public CuidadorU getById(int id) throws SQLException {
        String query = "SELECT * FROM cuidadoru WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CuidadorU cuidadoru = new CuidadorU();
                    cuidadoru.setid(rs.getInt("id"));
                   
                    cuidadoru.setpassword(rs.getString("password"));

                    return cuidadoru;
                }
            }
        }
        return null;
    }

 // Método para obtener todos los cuidadores
 public List<CuidadorU> obtenerCuidadores() {
    List<CuidadorU> cuidadores = new ArrayList<>();
    // Asegúrate de que tienes configurada la conexión
    String url = "jdbc:mysql://localhost:3306/tu_basededatos";
    String user = "tu_usuario";
    String password = "tu_contraseña";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM cuidadores")) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String especialidad = rs.getString("especialidad");
            cuidadores.add(new CuidadorU(id, nombre, especialidad));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cuidadores;
}


    @Override
       public void update(CuidadorU obj) throws SQLException {
        String query = "UPDATE cuidadoru SET username=?, password=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, obj.getUsername());
            stmt.setString(2, obj.getPassword());
  
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM cuidadoru WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }

    }


    @Override
    public List<CuidadorU> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    public boolean cambiarContrasena(String username, String nuevaContrasena) {
        String query = "UPDATE cuidadoru SET password = ? WHERE username = ?";
    
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nuevaContrasena);
            stmt.setString(2, username);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna true si se actualizó con éxito
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }



    
}

