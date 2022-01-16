package ru.java3000.yandexdrivetodofx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {

    private static Settings instance;
    Properties properties = new Properties();

    private static final String API_DISK_HOST = "cloud-api.yandex.net";
    private static final String API_OAUTH_HOST = "oauth.yandex.ru";
    private static final String API_VERSION = "/v1";
    private static final String API_TYPE = "/disk/";
    private static final String API_SCHEME = "https://";
    private static final String API_MIME_TYPE = "application/json";
    private static final String APP_ID = "692e18fbb968491fa3ae19e091ce5840";
    private static final String APP_OAUTH_URL_QUERY = "/authorize?response_type=token&client_id=";
    private static final String CONFIG_FILENAME = "config.properties";

    private String apiFullPath = API_SCHEME + API_DISK_HOST + API_VERSION + API_TYPE;
    private String appOauthFullPath = API_SCHEME + API_OAUTH_HOST + APP_OAUTH_URL_QUERY + APP_ID;
    private String APP_TOKEN = "";

    private boolean isSplashScreenNeeded = false;

    Path currentFolder = Paths.get("").toAbsolutePath();
    Path configFile = Path.of(currentFolder + File.separator + CONFIG_FILENAME);

    private Settings() {
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public void loadLocalSettings() {
        if (Files.exists(configFile, LinkOption.NOFOLLOW_LINKS)) {
            try (var file = new FileInputStream(configFile.toString())) {
                properties.load(file);
            } catch (IOException e) {
                //
            }
        } else {
            createLocalSettings();
        }
    }

    public void loadRemoteSettings() {
        //
    }

    public void saveLocalSettings() {
        if (Files.exists(configFile, LinkOption.NOFOLLOW_LINKS)) {
            properties.setProperty("APP_TOKEN", APP_TOKEN);
            properties.setProperty("APP_ID", APP_ID);
            properties.setProperty("isSplashScreenNeeded", String.valueOf(isSplashScreenNeeded));

            try (var file = new FileOutputStream(configFile.toString())) {
                properties.store(file, "");
            } catch (IOException e) {
                //
            }
        } else {
            if (createLocalSettings()) {
                properties.setProperty("APP_TOKEN", APP_TOKEN);
                properties.setProperty("APP_ID", APP_ID);
                properties.setProperty("isSplashScreenNeeded", String.valueOf(isSplashScreenNeeded));

                try (var file = new FileOutputStream(configFile.toString())) {
                    properties.store(file, "");
                } catch (IOException e) {
                    //
                }
            }
        }
    }

    public void saveRemoteSettings() {
        //
    }

    public boolean createLocalSettings() {
        File file = new File(configFile.toString());
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createRemoteSettings() {
        //
    }

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
}
