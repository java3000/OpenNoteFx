package ru.java3000.opennotefx.services.remotes;

import ru.java3000.opennotefx.entities.Notebook;
import ru.java3000.opennotefx.entities.Settings;
import ru.java3000.opennotefx.services.RemoteService;

public class BasicService implements RemoteService {
    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void register() {

    }

    @Override
    public boolean upload(String path, Settings.DownloadDataType type) {
        return false;
    }

    @Override
    public boolean download(String path, Settings.DownloadDataType type) {
        return false;
    }

    @Override
    public String shareNotebook(Notebook notebook) {
        return "";
    }

    @Override
    public boolean unshareNotebook(Notebook notebook) {
        return false;
    }

    @Override
    public boolean deleteNotebook(Notebook notebook, boolean permanently) {
        return false;
    }

    @Override
    public boolean restoreNotebook(Notebook notebook) {
        return false;
    }

    @Override
    public boolean createAppFolder() {
        return false;
    }

    @Override
    public boolean deleteAppFolder(boolean permanently) {
        return false;
    }

    @Override
    public boolean encryptData() {
        return false;
    }

    @Override
    public boolean decryptData() {
        return false;
    }
}
