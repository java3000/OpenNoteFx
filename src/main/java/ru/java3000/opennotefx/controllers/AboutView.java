package ru.java3000.opennotefx.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutView {
    public void closeView(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
