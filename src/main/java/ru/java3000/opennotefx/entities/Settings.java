package ru.java3000.opennotefx.entities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings {
    private static final String API_OAUTH_HOST = "oauth.yandex.ru";
    private static final String API_SCHEME = "https://";
    private static final String APP_ID = "692e18fbb968491fa3ae19e091ce5840";
    private static final String APP_OAUTH_URL_QUERY = "/authorize?response_type=token&client_id=";
    private static final String CONFIG_FILENAME = "config.xml";
    private static final String DATA_FOLDER_NAME = "data";
    private static final String CONFIG_FOLDER_NAME = "conf";
    private static final String APP_OAUTH_FULL_PATH = API_SCHEME + API_OAUTH_HOST + APP_OAUTH_URL_QUERY + APP_ID;
    private String APP_TOKEN = "";
    private String APP_LOGIN = "";

    private boolean isSplashScreenNeeded = false;

    static Path currentFolder = Paths.get("").toAbsolutePath();
    static Path configFile = Path.of(currentFolder + File.separator + CONFIG_FILENAME);
    static Path localDataFolder = Path.of(currentFolder + File.separator + DATA_FOLDER_NAME);
    static Path remoteDataFolder = Path.of(File.separator + DATA_FOLDER_NAME);
    static Path localConfigFolder = Path.of(currentFolder + File.separator + CONFIG_FOLDER_NAME);
    static Path remoteConfigFolder = Path.of(File.separator + CONFIG_FOLDER_NAME);
    static String dataFolderName = DATA_FOLDER_NAME;
    static String configFolderName = CONFIG_FOLDER_NAME;


    public enum DownloadDataType {
        NOTEBOOK(localDataFolder.toString(), remoteDataFolder.toString()),
        SETTINGS(localConfigFolder.toString(), remoteConfigFolder.toString());

        private final String localFolder;
        private final String remoteFolder;

        DownloadDataType(String localFolder, String remoteFolder) {
            this.localFolder = localFolder;
            this.remoteFolder = remoteFolder;
        }

        public String getLocalFolder(){
            return localFolder;
        }

        public String getRemoteFolder(){
            return remoteFolder;
        }
    }

    public String getappToken() {
        return APP_TOKEN;
    }

    public void setappToken(String appToken) {
        this.APP_TOKEN = appToken;
    }

    public String getAPP_LOGIN() {
        return APP_LOGIN;
    }

    public void setAPP_LOGIN(String APP_LOGIN) {
        this.APP_LOGIN = APP_LOGIN;
    }

    public boolean isSplashScreenNeeded() {
        return isSplashScreenNeeded;
    }

    public void setSplashScreenNeeded(boolean splashScreenNeeded) {
        isSplashScreenNeeded = splashScreenNeeded;
    }

    public String getAppOauthFullPath() {
        return APP_OAUTH_FULL_PATH;
    }

    public Path getCurrentFolder() {
        return currentFolder;
    }

    public Path getConfigFile() {
        return configFile;
    }

    public String getDataFolderName() {
        return dataFolderName;
    }
}
