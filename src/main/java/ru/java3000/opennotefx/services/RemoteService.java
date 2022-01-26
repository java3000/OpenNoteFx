package ru.java3000.opennotefx.services;

import ru.java3000.opennotefx.entities.Notebook;

import java.util.List;
import java.util.ServiceLoader;

public interface RemoteService {

    void login();
    void logout();
    void register();
    boolean uploadData();
    boolean downloadData();
    boolean uploadSettings();
    boolean downloadSettings();
    void shareNotebook(Notebook notebook);
    void unshareNotebook(Notebook notebook);
    boolean deleteNotebook(Notebook notebook);
    boolean wipeAllData();
    boolean deleteSettings();
    boolean createAppFolder();
    boolean deleteAppFolder();
    boolean encryptData();
    boolean decryptData();

    static List<RemoteService> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, RemoteService.class)
                .stream()
                .map(ServiceLoader.Provider::get).toList();
    }
}
