package com.usta.controllers;

import java.io.IOException;

import com.usta.App;
import com.usta.models.CuidadorU.CuidadorUImplDAO;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class PetrackController {
    @FXML
    private AnchorPane rootPane; 

    @FXML
    private void initialize() {
       
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), rootPane);
        transition.setFromX(-600); 
        transition.setToX(0); 
        transition.play(); 
    }
    @FXML
    private TextField Usuariotxt;

    @FXML
    private TextField Contraseñatxt;

    private CuidadorUImplDAO usuarioDAO = new CuidadorUImplDAO();

    @FXML
    private void switchToMenu() {
        String usuario = Usuariotxt.getText();
        String contrasena = Contraseñatxt.getText();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta("Error", "Usuario o contraseña no pueden estar vacíos");
            return;
        }

        if (usuarioDAO.validarCuidadorU(usuario, contrasena)) {
            try {
                
                App.setRoot("menu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos");
        }
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void switchToRegistro() throws IOException {
        App.setRoot("Registro");
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }

    public TextField getUsuariotxt() {
        return Usuariotxt;
    }

    public void setUsuariotxt(TextField usuariotxt) {
        Usuariotxt = usuariotxt;
    }

    public TextField getContraseñatxt() {
        return Contraseñatxt;
    }

    public void setContraseñatxt(TextField contraseñatxt) {
        Contraseñatxt = contraseñatxt;
    }

    public CuidadorUImplDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(CuidadorUImplDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    @FXML
private void switchToCambiarContrasena() {
    try {
        App.setRoot("cambiarContrasena"); // Asegúrate de que este es el nombre correcto de tu FXML
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
