package ru.java3000.note.controllers;

import jakarta.xml.bind.JAXBException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.java3000.note.OpenNoteFx;
import ru.java3000.note.entities.Notebook;
import ru.java3000.note.services.SavingService;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

public class Main_viewController {

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
        OpenNoteFx.getPrimaryStage().close();
    }

    public void addNotebook() throws XMLStreamException, JAXBException, IOException {
        String notebookName = getUserInput("Новый блокнот", "Введите название блокнота");

        Notebook noteBook = new Notebook();
        noteBook.setName(notebookName);
        noteBook.setCreationTime(LocalDateTime.now());

        mainTreeView.getRoot().getChildren().add(new TreeItem<>(noteBook));

        SavingService.saveNotebooksNotesLocal(noteBook);
    }

    //todo create several inputs and place them to helper class
    private String getUserInput(String caption, String text) {
        Dialog<String> notebookDialog = new TextInputDialog("");
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
        //todo replace with input from helper class
        Dialog noteRemoveDialog = new ChoiceDialog("");
        noteRemoveDialog.setTitle("Удалить блокнот");
        noteRemoveDialog.setHeaderText("Вы действительно хотите удалить блокнот " + ((TreeItem)actionEvent.getSource()).getValue().toString());
        Optional<String> entered = noteRemoveDialog.showAndWait();
        String result = "";

        if (entered.isPresent()) result = entered.get();
    }

    public void removeNote(ActionEvent actionEvent) {

    }

    public void editNote(ActionEvent actionEvent) {

    }

    public void openAboutDialog(ActionEvent actionEvent) {

    }

    public void openAccountsDialog(ActionEvent actionEvent) {
        //
    }

    public void openParametersDialog(ActionEvent actionEvent) {

    }
}
