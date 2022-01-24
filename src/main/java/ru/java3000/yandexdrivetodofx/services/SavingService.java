package ru.java3000.yandexdrivetodofx.services;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.java3000.yandexdrivetodofx.entities.Notebook;

import java.io.File;
import java.io.FileNotFoundException;

public final class SavingService {

    public static void saveSettingsLocal() throws JAXBException {
        String fileFullPathString = SettingsService.getInstance().currentFolder.toString() + "settings.xml";

        JAXBContext context = JAXBContext.newInstance(Notebook.class);
        var m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(SettingsService.getInstance(), new File(fileFullPathString));
    }

    public static void saveSettingsRemote(){
        //
    }

    public static void saveNotebooksNotesLocal(Notebook notebook) throws JAXBException, FileNotFoundException {
        String fileFullPathString = SettingsService.getInstance().currentFolder.toString() + notebook.getName() + ".xml";

        JAXBContext context = JAXBContext.newInstance(Notebook.class);
        var m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(notebook, new File(fileFullPathString));
    }

    public static void saveNotebooksNotesRemote(){

    }

    public static void shedulePeriodicSaving(){

    }
}
