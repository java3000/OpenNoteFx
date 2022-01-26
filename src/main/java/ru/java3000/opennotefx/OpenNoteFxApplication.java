package ru.java3000.opennotefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.java3000.opennotefx.services.SettingsService;

import java.io.IOException;
import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class OpenNoteFxApplication extends Application {

    public static final String TITLE = "Yandex Disk ToDo!";
    SettingsService settingsService = SettingsService.getInstance();
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

        if (settingsService.getSettings().isSplashScreenNeeded()) loadSplashScreen(stage);
    }

    private void loadSettings() {
        //todo this is in save service now
        //settingsService.getSettings().

        if (settingsService.getSettings().getappToken().isEmpty()) {
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
        FXMLLoader fxmlLoader = new FXMLLoader(OpenNoteFxApplication.class.getResource("main_view.fxml"));
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
        FXMLLoader fxmlLoader = new FXMLLoader(OpenNoteFxApplication.class.getResource("splash-screen-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public void loadYandexScreen(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OpenNoteFxApplication.class.getResource("yandex_first_authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public void loadRemoteServicesPlugins() {
        Path pluginsDir = Paths.get("plugins");

        // Будем искать плагины в папке plugins
        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        // Пусть ModuleFinder найдёт все модули в папке plugins и вернёт нам список их имён
        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name).toList();

        // Создадим конфигурацию, которая выполнит резолюцию указанных модулей
        // (проверит корректность графа зависимостей)
        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        // Создадим слой модулей для плагинов
        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

        // Найдём все реализации сервиса IService в слое плагинов и в слое Boot
        //List<RemoteService> services = RemoteService.getServices(layer);
        //for (RemoteService service : services) {
        //service.doJob();
        //}
    }
}