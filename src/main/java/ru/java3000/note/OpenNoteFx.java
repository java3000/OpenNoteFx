package ru.java3000.note;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.java3000.note.entities.Settings;

import java.io.IOException;
import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;


public class OpenNoteFx extends Application {

    public static final String TITLE = "Yandex Disk ToDo!";
    Settings settings = Settings.getInstance();
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(OpenNoteFx.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("ru.java3000.note.messages"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("%app.title");
        stage.setScene(scene);
        stage.show();*/

        primaryStage = stage;
        loadSettings();

        if (Settings.getInstance().isSplashScreenNeeded()) loadSplashScreen(stage);
    }

    public static void main(String[] args) {
        launch();
    }

    private void loadSettings() {
        //todo this is in save service now
        //settingsService.getSettings().

        /*if (Settings.getInstance().getAppToken().isEmpty()) {
            Stage stage = new Stage();
            try {
                loadYandexScreen(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {*/
        loadMainWindow();
        //}
    }

    private void loadMainWindow() {
        URL location = OpenNoteFx.class.getResource("main_view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        fxmlLoader.setResources(ResourceBundle.getBundle("ru.java3000.note.messages"));
        //fxmlLoader.setResources(ResourceBundle.getBundle("messages", Locale.getDefault()));

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

    public void loadSplashScreen(Stage stage) throws IOException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(OpenNoteFx.class.getResource("splash-screen-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public void loadYandexScreen(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(OpenNoteFx.class.getResource("yandex_first_authorization.fxml"));
        System.out.println(fxmlLoader.getLocation());
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