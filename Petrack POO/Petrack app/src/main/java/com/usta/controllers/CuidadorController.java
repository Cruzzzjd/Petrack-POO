package com.usta.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.usta.App;
import com.usta.models.DatabaseConnection;
import com.usta.models.CuidadorU.CuidadorU;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CuidadorController {

    @FXML
    private TableColumn<?, ?> ApellidosTbl;

    @FXML
    private TextField ApellidosTxt;

    @FXML
    private Button AregarBtn;

    @FXML
    private TableView<?> CuidadorTbl;

    @FXML
    private TableColumn<?, ?> DocumentoTbl;

    @FXML
    private TextField DocumentoTxt;

    @FXML
    private Button EliminarBtn;

    @FXML
    private Button MenuBtn;

    @FXML
    private TableColumn<?, ?> NombreTbl;

    @FXML
    private TextField NombreTxt;

    @FXML
    private TextField TelefonoTxt;


    @FXML
private void Agregardueno() {
    String nombre = NombreTxt.getText();
    String apellidos = ApellidosTxt.getText();
    String documento = DocumentoTxt.getText();
    String telefono = TelefonoTxt.getText();

    // Validación básica
    if (nombre.isEmpty() || apellidos.isEmpty() || documento.isEmpty() || telefono.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Por favor, completa todos los campos.");
        alert.showAndWait();
        return;
    }

    String sql = "INSERT INTO dueno (nombre, apellidos, documento, telefono) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, nombre);
        pstmt.setString(2, apellidos);
        pstmt.setString(3, documento);
        pstmt.setString(4, telefono);
        
        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("¡Se ha agregado un nuevo Dueño!");
            alert.showAndWait();
            cargarduenos(); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Error al agregar el dueño.");
        alert.showAndWait();
    }
}


    private void cargarduenos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cargarduenos'");
    }
    
  @FXML
    void switchToMenu() throws IOException {
        App.setRoot("menu");
    }


}




