package ru.java3000.note.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Settings_viewController {
    @FXML
    public CheckBox showSplashScreenOption;
    @FXML
    public TableView accountsTable;
    @FXML
    public TableColumn serviceColumn;
    @FXML
    public TableColumn loginColumn;
    @FXML
    public TableColumn passwordColumn;
    @FXML
    public Button saveSettingsButton;
    @FXML
    public Button cancelSettingsButton;
}
