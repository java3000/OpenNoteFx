package ru.java3000.opennotefx.entities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings {
    private static final String API_DISK_HOST = "cloud-api.yandex.net";
    private static final String API_OAUTH_HOST = "oauth.yandex.ru";
    private static final String API_VERSION = "/v1";
    private static final String API_PATH = "resources/";
    private static final String API_TYPE = "/disk/";
    private static final String API_UPLOAD = "/upload?path=%s&overwrite=%s"; //true?false
    private static final String API_SCHEME = "https://";
    private static final String API_MIME_TYPE = "application/json";
    private static final String APP_ID = "692e18fbb968491fa3ae19e091ce5840";
    private static final String APP_OAUTH_URL_QUERY = "/authorize?response_type=token&client_id=";
    private static final String CONFIG_FILENAME = "config.xml";
    private static final String DATA_FOLDER_NAME = "data";

    private String apiUploadFile = API_SCHEME + API_DISK_HOST + API_VERSION + API_TYPE + API_PATH + API_UPLOAD;
    private String apiFullPath = API_SCHEME + API_DISK_HOST + API_VERSION + API_TYPE;
    private String appOauthFullPath = API_SCHEME + API_OAUTH_HOST + APP_OAUTH_URL_QUERY + APP_ID;
    private String APP_TOKEN = "";

    private boolean isSplashScreenNeeded = false;

    Path currentFolder = Paths.get("").toAbsolutePath();
    Path configFile = Path.of(currentFolder + File.separator + CONFIG_FILENAME);
    Path dataFolder = Path.of(currentFolder + File.separator + DATA_FOLDER_NAME);

    public String getappToken() {
        return APP_TOKEN;
    }

    public void setappToken(String appToken) {
        this.APP_TOKEN = appToken;
    }

    public boolean isSplashScreenNeeded() {
        return isSplashScreenNeeded;
    }

    public void setSplashScreenNeeded(boolean splashScreenNeeded) {
        isSplashScreenNeeded = splashScreenNeeded;
    }

    public String getApiFullPath() {
        return apiFullPath;
    }

    public String getAppOauthFullPath() {
        return appOauthFullPath;
    }

    public Path getCurrentFolder() {
        return currentFolder;
    }

    public Path getConfigFile() {
        return configFile;
    }

    public Path getDataFolder() {
        return dataFolder;
    }
}
