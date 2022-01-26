package ru.java3000.opennotefx.services;

import ru.java3000.opennotefx.entities.Settings;

public class SettingsService {

    private static SettingsService instance;
    private Settings settings = new Settings();

    private SettingsService() {
    }

    public static SettingsService getInstance() {
        if (instance == null) {
            instance = new SettingsService();
        }
        return instance;
    }

    public Settings getSettings() {
        return settings;
    }
}
