package com.usta.controllers;

import java.io.IOException;
import com.usta.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class menuController {
  

    @FXML
    private Button Agregarbtn;

    public Button getAgregarbtn() {
        return Agregarbtn;
    }

    public void setAgregarbtn(Button agregarbtn) {
        Agregarbtn = agregarbtn;
    }

    @FXML
    void switchToCuidador() throws IOException {
        App.setRoot("Cuidador");
    }
@FXML
    void switchToMascota(ActionEvent event) {
        try {
            App.setRoot("Mascota"); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}


