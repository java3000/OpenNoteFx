package ru.java3000.note.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.kordamp.ikonli.javafx.FontIcon;
import ru.java3000.note.OpenNoteFx;
import ru.java3000.note.entities.Note;
import ru.java3000.note.entities.NoteTreeItem;
import ru.java3000.note.entities.Notebook;
import ru.java3000.note.helpers.TextFieldTreeCellImpl;

import java.text.MessageFormat;import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class Main_viewController {

    @FXML
    private TreeView mainTreeView;
    //@FXML
    //private ContextMenu cmTF;
    @FXML
    private MenuItem close;
    @FXML
    private MenuItem about;
    @FXML
    private TabPane noteTabs;
    @FXML
    private MenuBar systemMenu;

    public  boolean empty = true;
    Locale currentLocale;
    ResourceBundle messages;

    public void initialize() {
        TreeItem<Object> root = new TreeItem<>();
        root.setExpanded(true);
        mainTreeView.setEditable(true);
        mainTreeView.setCellFactory((Callback<TreeView<NoteTreeItem>, TreeCell<NoteTreeItem>>) p -> new TextFieldTreeCellImpl());
        mainTreeView.setRoot(root);

        //todo get locale from settings, or platform if not in settings
        currentLocale = new Locale("ru", "RU");
        messages = ResourceBundle.getBundle("ru.java3000.note.messages", currentLocale);

        //todo place somethere
       /* if(mainTreeView.getRoot().getChildren().isEmpty()) {
            cmTF.getItems().stream().filter(x -> x.getId().matches("addnote")).findFirst().get().setDisable(true);
            cmTF.getItems().stream().filter(x -> x.getId().matches("removebook")).findFirst().get().setDisable(true);
            systemMenu.getMenus().stream().filter(x -> x.getId().matches("uppermenu")).findFirst().get()
                    .getItems().stream().filter(x -> x.getId().matches("createNote")).findFirst().get().setDisable(true);
        }*/
    }

    public void closeApp() {
        OpenNoteFx.getPrimaryStage().close();
    }

    public void openAboutDialog(ActionEvent actionEvent) {

    }

    public void openAccountsDialog(ActionEvent actionEvent) {
        //
    }

    public void openParametersDialog(ActionEvent actionEvent) {

    }

    public void addNotebook() {
        String notebookName = messages.getString("new.notebook"); //todo i18ize

        Notebook noteBook = new Notebook();
        noteBook.setName(notebookName);
        noteBook.setCreationTime(LocalDateTime.now());

        mainTreeView.getRoot().getChildren().add(new TreeItem<>(noteBook, new FontIcon("ti-agenda:24")));

        //todo place somethere
        /*if(!mainTreeView.getRoot().getChildren().isEmpty()) {
            cmTF.getItems().stream().filter(x -> x.getId().matches("addnote")).findFirst().get().setDisable(false);
            cmTF.getItems().stream().filter(x -> x.getId().matches("removebook")).findFirst().get().setDisable(false);
            systemMenu.getMenus().stream().filter(x -> x.getId().matches("uppermenu")).findFirst().get()
                    .getItems().stream().filter(x -> x.getId().matches("createNote")).findFirst().get().setDisable(false);
        }*/
    }

    public void addNote(ActionEvent actionEvent) {
        String noteName = messages.getString("new.note");

        Note note = new Note();
        note.setName(noteName);
        note.setCreationDateTime(LocalDateTime.now());

        TreeItem newNote = new TreeItem<String>("New Employee");
        //getTreeItem().getChildren().add(newNote);
        //source.nextSibling(new TreeItem<>(note, new FontIcon("ti-notepad:24")));

    }

    public void removeNotebook(ActionEvent actionEvent) {
        //
    }
}
