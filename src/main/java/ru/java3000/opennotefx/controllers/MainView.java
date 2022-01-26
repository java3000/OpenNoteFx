package ru.java3000.opennotefx.controllers;

import jakarta.xml.bind.JAXBException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.java3000.opennotefx.OpenNoteFxApplication;
import ru.java3000.opennotefx.entities.Notebook;
import ru.java3000.opennotefx.services.SavingService;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

public class MainView {

    @FXML
    private TreeView mainTreeView;
    @FXML
    private ContextMenu cmTF;
    @FXML
    private MenuItem close;
    @FXML
    private MenuItem about;
    @FXML
    private TabPane noteTabs;

    public void initialize() {
        TreeItem<Object> root = new TreeItem<>();
        root.setExpanded(true);
        mainTreeView.setRoot(root);

        //todo add from file
    }

    public void closeApp() {
        OpenNoteFxApplication.getPrimaryStage().close();
    }

    public void addNotebook() throws XMLStreamException, JAXBException, IOException {
        String notebookName = getUserInput("Новый блокнот", "Введите название блокнота");

        Notebook noteBook = new Notebook();
        noteBook.setName(notebookName);
        noteBook.setCreationTime(LocalDateTime.now());

        mainTreeView.getRoot().getChildren().add(new TreeItem<>(noteBook));

        SavingService.saveNotebooksNotesLocal(noteBook);
    }

    private String getUserInput(String caption, String text) {
        Dialog notebookDialog = new TextInputDialog("");
        notebookDialog.setTitle(caption);
        notebookDialog.setHeaderText(text);

        Optional<String> entered = notebookDialog.showAndWait();
        String result = "";

        if (entered.isPresent()) result = entered.get();

        return result;
    }

    public void addNote(ActionEvent actionEvent) {

    }

    public void removeNotebook(ActionEvent actionEvent) {

    }

    public void removeNote(ActionEvent actionEvent) {

    }

    public void editNote(ActionEvent actionEvent) {

    }
}
