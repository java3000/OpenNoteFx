package ru.java3000.opennotefx.services;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.java3000.opennotefx.entities.Notebook;
import ru.java3000.opennotefx.entities.Settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class SavingService {

    private SavingService() {
    }

    public static void saveSettingsLocal() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Settings.class);
        var m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(Settings.getInstance(), new File(Settings.getInstance().getSettingsPathString()));
    }

    //todo think about array of notebooks
    public static void saveNotebooksNotesLocal(Notebook notebook) throws JAXBException, FileNotFoundException {
        String fileFullPathString = Settings.getInstance().getDataFolderName() + File.separator + notebook.getName() + ".xml";

        JAXBContext context = JAXBContext.newInstance(Notebook.class);
        var m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(notebook, new File(fileFullPathString));
    }

    //todo think about array of notebooks
    public static void sheduledPeriodicDataSaving(Notebook notebook, int period) {

        if (period == 0) {
            period = 5; // five minutes
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    saveNotebooksNotesLocal(notebook);
                } catch (JAXBException | FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }, 1L, 1000L * 60 * period);
    }

    public static Settings loadSettingsLocal() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Settings.class);
        var m = context.createUnmarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return (Settings) m.unmarshal(new File(Settings.getInstance().getSettingsPathString()));
    }

    public static List<Notebook> loadDataLocal() {
        Path fileFullPathString = Path.of(Settings.getInstance().getDataFolderName());
        List<Notebook> notebooks = new ArrayList<>();

        try (var fileStream = Files.list(fileFullPathString)) {
            for (var file : fileStream.toList()) {
                JAXBContext context = JAXBContext.newInstance(Notebook.class);
                var m = context.createUnmarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                Notebook n = (Notebook) m.unmarshal(new File(file.toString()));
                notebooks.add(n);
            }
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return notebooks;
    }

    public static void saveSettingsRemote() {
        //
    }

    public static void saveNotebooksNotesRemote() {
        //
    }

    public static void loadSettingsRemote() {
        //
    }

    public static void loadDataRemote() {
        //
    }

    public static void syncSettingsLocalToRemote() {
        //
    }

    public static void syncSettingsRemoteToLocal() {
        //
    }

    public static void syncDataLocalToRemote() {
        //
    }

    public static void syncDataRemoteToLocal() {
        //
    }

}
