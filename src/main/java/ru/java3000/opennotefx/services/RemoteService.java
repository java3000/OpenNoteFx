package ru.java3000.opennotefx.services;

import ru.java3000.opennotefx.entities.Notebook;
import ru.java3000.opennotefx.entities.Settings;

import java.util.List;
import java.util.ServiceLoader;

public interface RemoteService {

    void login();
    void logout();
    void register();
    boolean upload(String path, Settings.DownloadDataType type);
    boolean download(String path, Settings.DownloadDataType type);
    String shareNotebook(Notebook notebook);
    boolean unshareNotebook(Notebook notebook);
    boolean deleteNotebook(Notebook notebook, boolean permanently);
    boolean restoreNotebook(Notebook notebook);
    boolean createAppFolder();
    boolean deleteAppFolder(boolean permanently);
    boolean encryptData();
    boolean decryptData();

    static List<RemoteService> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, RemoteService.class)
                .stream()
                .map(ServiceLoader.Provider::get).toList();
    }
}
