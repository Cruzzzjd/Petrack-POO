package com.usta.controllers;

import java.io.IOException;

import com.usta.App;
import com.usta.models.CuidadorU.CuidadorU;
import com.usta.models.CuidadorU.CuidadorUImplDAO;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RegistroController {
    @FXML
    private TextField Usuariotxt;

    @FXML
    private TextField Contraseñatxt;

    private CuidadorUImplDAO cuidadorUImplDAO = new CuidadorUImplDAO();

    @FXML
    private void registrarUsuario() {
        String usuario = Usuariotxt.getText();
        String contrasena = Contraseñatxt.getText();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta("Error", "Usuario o contraseña no pueden estar vacíos");
            return;
        }

        // Aquí podrías agregar lógica para verificar si el usuario ya existe.
        try {
            cuidadorUImplDAO.add(new CuidadorU(usuario, contrasena));

            mostrarAlerta("Éxito", "Usuario registrado correctamente");
            App.setRoot("Petrack");

        } catch (Exception e) {
            mostrarAlerta("Error", "Error, no se pudo registrar");
        }
       
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
private void volverALogin() {
    try {
        App.setRoot("Petrack"); 
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
