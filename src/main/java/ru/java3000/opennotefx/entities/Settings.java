package ru.java3000.opennotefx.entities;

import jakarta.xml.bind.annotation.*;

import java.io.File;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Settings {

    private static Settings instance;

    private static final String APP_ID = "692e18fbb968491fa3ae19e091ce5840";
    private static final String APP_OAUTH_URL_QUERY = "https://oauth.yandex.ru/authorize?response_type=token&client_id=";
    private static final String APP_OAUTH_FULL_PATH = APP_OAUTH_URL_QUERY + APP_ID;
    private static final String CONFIG_FILENAME = "config.xml";
    private static final String DATA_FOLDER_NAME = "data";
    private static final String CONFIG_FOLDER_NAME = "conf";
    private static final String PLUGINS_FOLDER_NAME = "plugins";

    private Settings() {

    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    @XmlElement
    private String APP_TOKEN = "";
    @XmlElement
    private String APP_LOGIN = "";
    @XmlElement
    private boolean isSplashScreenNeeded = false;

    public enum DownloadDataType {
        NOTEBOOK(DATA_FOLDER_NAME, File.separator + DATA_FOLDER_NAME),
        SETTINGS(CONFIG_FOLDER_NAME, File.separator + CONFIG_FOLDER_NAME),
        PLUGINS(PLUGINS_FOLDER_NAME, File.separator + PLUGINS_FOLDER_NAME);

        private final String localFolder;
        private final String remoteFolder;

        DownloadDataType(String localFolder, String remoteFolder) {
            this.localFolder = localFolder;
            this.remoteFolder = remoteFolder;
        }

        public String getLocalFolder() {
            return localFolder;
        }

        public String getRemoteFolder() {
            return remoteFolder;
        }
    }

    public boolean isSplashScreenNeeded() {
        return isSplashScreenNeeded;
    }

    public void setSplashScreenNeeded(boolean splashScreenNeeded) {
        isSplashScreenNeeded = splashScreenNeeded;
    }

    public String getAppToken() {
        return APP_TOKEN;
    }

    public void setAppToken(String appToken) {
        this.APP_TOKEN = appToken;
    }

    public String getAppLogin() {
        return APP_LOGIN;
    }

    public void setAppLogin(String appLogin) {
        this.APP_LOGIN = appLogin;
    }

    public String getDataFolderName() {
        return DATA_FOLDER_NAME;
    }

    public String getSettingsFolderName() {
        return CONFIG_FOLDER_NAME;
    }

    public String getPluginsFolderName() {
        return PLUGINS_FOLDER_NAME;
    }

    public String getConfigFileName() {
        return CONFIG_FILENAME;
    }

    public String getAppOauthFullPath() {
        return APP_OAUTH_FULL_PATH;
    }

    public  String getSettingsPathString(){
        return CONFIG_FOLDER_NAME + File.separator + CONFIG_FILENAME;
    }
}
