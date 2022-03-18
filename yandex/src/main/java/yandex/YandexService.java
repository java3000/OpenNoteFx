package yandex;

import com.yandex.disk.rest.*;
import com.yandex.disk.rest.exceptions.CancelledUploadingException;
import com.yandex.disk.rest.exceptions.ServerException;
import com.yandex.disk.rest.exceptions.ServerIOException;
import com.yandex.disk.rest.exceptions.WrongMethodException;
import com.yandex.disk.rest.json.Link;
import com.yandex.disk.rest.json.Resource;
import ru.java3000.opennotefx.entities.Notebook;
import ru.java3000.opennotefx.entities.Settings;
import ru.java3000.opennotefx.services.RemoteService;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class YandexService implements RemoteService {

    private static final Logger logger = Logger.getLogger("ru/java3000/opennotefx/yandex");

    private RestClient client;

    public YandexService() {

        //todo may be bad logic.
        String user = Settings.getInstance().getAppLogin();
        String token = Settings.getInstance().getAppToken();

        if (user.isEmpty() || token.isEmpty()) throw new IllegalArgumentException("user or token is empty");

        Credentials credentials = new Credentials(user, token);
        this.client = new RestClient(credentials);
    }

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
        File local = switch (type) {
            case NOTEBOOK -> new File(Settings.DownloadDataType.NOTEBOOK.getLocalFolder() + File.separator + path);
            case SETTINGS -> new File(Settings.DownloadDataType.SETTINGS.getLocalFolder() + File.separator + path);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };

        String serverPath = switch (type) {
            case NOTEBOOK -> Settings.DownloadDataType.NOTEBOOK.getRemoteFolder();
            case SETTINGS -> Settings.DownloadDataType.SETTINGS.getRemoteFolder();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };

        Link link = null;
        try {
            link = client.getUploadLink(serverPath, true);
        } catch (ServerIOException | WrongMethodException | IOException e) {
            e.printStackTrace();
        }

        final int lastPass = 2;
        for (int i = 0; i <= lastPass; i++) {
            final int pass = i;
            try {
                client.uploadFile(link, true, local, new ProgressListener() {
                    boolean doCancel = false;

                    @Override
                    public void updateProgress(long loaded, long total) {
                        logger.info("updateProgress: pass=" + pass + ": " + loaded + " / " + total);
                    }

                    @Override
                    public boolean hasCancelled() {
                        if (doCancel) {
                            logger.info("cancelled");
                        }
                        return doCancel;
                    }
                });
            } catch (CancelledUploadingException | ServerException ex) {
                logger.info("CancelledUploadingException");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean download(String path, Settings.DownloadDataType type) {

        File local = switch (type) {
            case NOTEBOOK -> new File(Settings.DownloadDataType.valueOf("NOTEBOOK") + File.separator + path);
            case SETTINGS -> new File(Settings.DownloadDataType.valueOf("SETTINGS") + File.separator + path);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };

        try {
            client.downloadFile(path, local, new ProgressListener() {
                @Override
                public void updateProgress(long loaded, long total) {
                    logger.info("updateProgress: " + loaded + " / " + total);
                }

                @Override
                public boolean hasCancelled() {
                    return false;
                }
            });
            return true;
        } catch (IOException | ServerException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String shareNotebook(Notebook notebook) {
        String path = notebook.getRemoteLocation();

        try {
            client.publish(path);
        } catch (ServerIOException | IOException e) {
            e.printStackTrace();
        }
        try {
            client.getResources(new ResourcesArgs.Builder()
                    .setPath(path)
                    .setParsingHandler(new ResourcesHandler() {
                        @Override
                        public void handleItem(Resource item) {
                            notebook.setShareLink(item.getPublicUrl());
                        }
                    })
                    .build());
        } catch (IOException | ServerIOException e) {
            e.printStackTrace();
        }
        return notebook.getShareLink();
    }

    @Override
    public boolean unshareNotebook(Notebook notebook) {
        String path = notebook.getRemoteLocation();

        try {
            client.unpublish(path);
        } catch (ServerIOException | IOException e) {
            e.printStackTrace();
        }
        try {
            client.getResources(new ResourcesArgs.Builder()
                    .setPath(path)
                    .setParsingHandler(new ResourcesHandler() {
                        @Override
                        public void handleItem(Resource item) {
                            notebook.setShareLink("");
                        }
                    })
                    .build());
            return true;
        } catch (IOException | ServerIOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteNotebook(Notebook notebook, boolean permanently) {
        try {
            Link link = client.delete(notebook.getRemoteLocation(), permanently);
            notebook.setRemoteLocation(link.getHref());
            notebook.setInTrash(true);
            return true;
        } catch (ServerIOException | IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean restoreNotebook(Notebook notebook) {
        try {
            Link link = client.restoreFromTrash("/" + notebook.getName(), null, null);
            notebook.setRemoteLocation(link.getHref());
            return true;
        } catch (ServerIOException | IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createAppFolder() {

        String path = "/" + Settings.getInstance().getDataFolderName();
        try {
            client.makeFolder(path);
            return true;
        } catch (ServerIOException | IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAppFolder(boolean permanently) {
        String path = "/" + Settings.getInstance().getDataFolderName();
        try {
            client.delete(path, permanently);
            return true;
        } catch (ServerIOException | IOException ex) {
            ex.printStackTrace();
            return false;
        }
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
