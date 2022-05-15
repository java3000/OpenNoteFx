package ru.java3000.note.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.kordamp.ikonli.javafx.FontIcon;
import ru.java3000.note.OpenNoteFx;
import ru.java3000.note.entities.Note;
import ru.java3000.note.entities.Notebook;
import ru.java3000.note.helpers.TextFieldTreeCellImpl;

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
    @FXML
    private MenuBar systemMenu;

    public  boolean empty = true;

    public void initialize() {
        TreeItem<Object> root = new TreeItem<>();
        root.setExpanded(true);
        mainTreeView.setRoot(root);
        mainTreeView.setEditable(true);
        mainTreeView.setCellFactory((Callback<TreeView<Object>, TreeCell<Object>>) p -> new TextFieldTreeCellImpl());

        //todo place somethere
        /*if(mainTreeView.getRoot().getChildren().isEmpty()) {
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
        String notebookName = "New Notebook"; //todo i18ize

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
        String noteName = "New Note";

        Note note = new Note();
        note.setCaption(noteName);
        note.setCreationDateTime(LocalDateTime.now());

        //TreeItem source = (TreeItem)actionEvent.getSource();
        //source.getChildren().add(new TreeItem<>(note, new FontIcon("ti-notepad:24")));
        //source.getChildren().add(new TreeItem<>(note, new FontIcon("ti-receipt:24")));

    }

    public void removeNotebook(ActionEvent actionEvent) {
        //todo replace with input from helper class
        Dialog noteRemoveDialog = new ChoiceDialog("");
        noteRemoveDialog.setTitle("Удалить блокнот");
        noteRemoveDialog.setHeaderText("Вы действительно хотите удалить блокнот " + ((TreeItem)actionEvent.getSource()).getValue().toString());
        Optional<String> entered = noteRemoveDialog.showAndWait();
        String result = "";

        if (entered.isPresent()) result = entered.get();
        //todo
    }
}
