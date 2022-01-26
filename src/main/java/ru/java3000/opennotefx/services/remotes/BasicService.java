package ru.java3000.opennotefx.services.remotes;

import ru.java3000.opennotefx.entities.Notebook;
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
    public boolean uploadData() {
        return false;
    }

    @Override
    public boolean downloadData() {
        return false;
    }

    @Override
    public boolean uploadSettings() {
        return false;
    }

    @Override
    public boolean downloadSettings() {
        return false;
    }

    @Override
    public void shareNotebook(Notebook notebook) {

    }

    @Override
    public void unshareNotebook(Notebook notebook) {

    }

    @Override
    public boolean deleteNotebook(Notebook notebook) {
        return false;
    }

    @Override
    public boolean wipeAllData() {
        return false;
    }

    @Override
    public boolean deleteSettings() {
        return false;
    }

    @Override
    public boolean createAppFolder() {
        return false;
    }

    @Override
    public boolean deleteAppFolder() {
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
