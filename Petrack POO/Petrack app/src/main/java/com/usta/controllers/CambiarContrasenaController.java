package com.usta.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.usta.models.CuidadorU.CuidadorU;
import com.usta.models.CuidadorU.CuidadorUImplDAO;

public class CambiarContrasenaController {

    @FXML
    private TextField nuevaContrasenaTxt;

    @FXML
    private TextField confirmarContrasenaTxt;

    private CuidadorUImplDAO usuarioDAO = new CuidadorUImplDAO();
    CuidadorU usuario; 
    @FXML
    private void cambiarContrasena() {
        String nuevaContrasena = nuevaContrasenaTxt.getText();
        String confirmarContrasena = confirmarContrasenaTxt.getText();
        usuario=null;// areglar esto XD

        if (nuevaContrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            mostrarAlerta("Error", "Las contraseñas no pueden estar vacías");
            return;
        }

        if (!nuevaContrasena.equals(confirmarContrasena)) {
            mostrarAlerta("Error", "Las contraseñas no coinciden");
            return;
        }

        if (usuarioDAO.cambiarContrasena(usuario, nuevaContrasena)) {
            mostrarAlerta("Éxito", "Contraseña cambiada exitosamente");
        } else {
            mostrarAlerta("Error", "No se pudo cambiar la contraseña");
        }
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}