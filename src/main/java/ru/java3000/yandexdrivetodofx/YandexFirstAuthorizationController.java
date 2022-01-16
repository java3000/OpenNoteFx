package ru.java3000.yandexdrivetodofx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class YandexFirstAuthorizationController implements Initializable {

    @FXML
    WebView browser = new WebView();

    private WebEngine webEngine;
    private Settings settings = Settings.getInstance();

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
                    settings.setappToken(ref.split("&")[0].split("=")[1]);
                    settings.saveLocalSettings();

                    FXMLLoader fxmlLoader = new FXMLLoader(YandexDiskToDoFxApplication.class.getResource("main_view.fxml"));
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

        webEngine.load(settings.getAppOauthFullPath());
    }
}
