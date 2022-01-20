package ru.java3000.yandexdrivetodofx;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDateTime;
import java.util.Optional;

public class MainView {
    public TreeView mainTreeView;
    public ContextMenu cmTF;
    public MenuItem close;
    public MenuItem about;
    public TabPane noteTabs;

    public void initialize() {
        TreeItem<Object> root = new TreeItem<>();
        root.setExpanded(true);
        mainTreeView.setRoot(root);
    }

    public void closeApp() {
        YandexDiskToDoFxApplication.getPrimaryStage().close();
    }

    public void addNotebook() {
        String notebookName = getUserInput("Новый блокнот", "Введите название блокнота");

        Notebook noteBook = new Notebook();
        noteBook.setName(notebookName);
        noteBook.setCreationTime(LocalDateTime.now());


        mainTreeView.getRoot().getChildren().add(new TreeItem<>(noteBook));
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
