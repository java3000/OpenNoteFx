package ru.java3000.opennotefx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import ru.java3000.opennotefx.services.SettingsService;
import ru.java3000.opennotefx.OpenNoteFxApplication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class YandexFirstAuth implements Initializable {

    @FXML
    WebView browser = new WebView();

    private WebEngine webEngine;
    private SettingsService settingsService = SettingsService.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebEngine webEngine = browser.getEngine();
        browser.setContextMenuEnabled(false);
        browser.autosize();
        webEngine.locationProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.startsWith("https://callback/")){
                URL url = null;
                try {
                    url = new URL(newValue);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                String ref = url.getRef();
                if (ref != null) {
                    settingsService.getSettings().setappToken(ref.split("&")[0].split("=")[1]);
                    //todo
                    //settingsService.getSettings().saveLocalSettings();

                    FXMLLoader fxmlLoader = new FXMLLoader(OpenNoteFxApplication.class.getResource("main_view.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage stage = (Stage) browser.getScene().getWindow();
                    stage.setScene(scene);
                }
            }
        });

        webEngine.load(settingsService.getSettings().getAppOauthFullPath());
    }
}
