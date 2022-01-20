package ru.java3000.yandexdrivetodofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class YandexDiskToDoFxApplication extends Application {

    public static final String TITLE = "Yandex Disk ToDo!";
    Settings settings = Settings.getInstance();
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }



    @Override
    public void start(Stage stage) throws IOException {

        synchronized (this) {
            primaryStage = stage;
        }

        loadSettings();

        if (settings.isSplashScreenNeeded()) loadSplashScreen(stage);
    }

    private void loadSettings() {
        settings.loadLocalSettings();

        if (!settings.properties.containsKey("APP_TOKEN") || settings.properties.getProperty("APP_TOKEN").isEmpty()) {
            Stage stage = new Stage();
            try {
                loadYandexScreen(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            loadMainWindow();
        }
    }

    private void loadMainWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(YandexDiskToDoFxApplication.class.getResource("main_view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void loadSplashScreen(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(YandexDiskToDoFxApplication.class.getResource("splash-screen-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public void loadYandexScreen(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(YandexDiskToDoFxApplication.class.getResource("yandex_first_authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }
}