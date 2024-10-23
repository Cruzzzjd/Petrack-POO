package com.usta.controllers;

import java.io.IOException;

import com.usta.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MascotaController {

    @FXML
    private Button AregarBtn;

    @FXML
    private ComboBox<?> CuidadorCbx;

    @FXML
    private TableColumn<?, ?> CuidadorTbl;

    @FXML
    private Button EliminarBtn1;

    @FXML
    private TableColumn<?, ?> EspecieTbl;

    @FXML
    private TextField EspecieTxt;

    @FXML
    private TableView<?> MascotasTbl;

    @FXML
    private Button MenuBtn;

    @FXML
    private TableColumn<?, ?> NombreTbl;

    @FXML
    private TextField NombreTxt;

    @FXML
    private TextField RazaTxt;
     @FXML
    void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

}
