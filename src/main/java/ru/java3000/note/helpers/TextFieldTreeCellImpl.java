package ru.java3000.note.helpers;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import org.kordamp.ikonli.javafx.FontIcon;
import ru.java3000.note.entities.Note;
import ru.java3000.note.entities.NoteTreeItem;
import ru.java3000.note.entities.NoteTreeItemType;
import ru.java3000.note.entities.Notebook;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

public final class TextFieldTreeCellImpl extends TreeCell<NoteTreeItem> {
    private TextField textField;
    private ContextMenu noteMenu = new ContextMenu();
    private ContextMenu notebookMenu = new ContextMenu();
    Locale currentLocale;
    ResourceBundle messages;

    public TextFieldTreeCellImpl() {
        currentLocale = new Locale("ru", "RU");
        messages = ResourceBundle.getBundle("ru.java3000.note.messages", currentLocale);

        MenuItem addNoteMenuItem = new MenuItem("Add Note"); //todo i18n
        noteMenu.getItems().add(addNoteMenuItem);
        addNoteMenuItem.setOnAction((EventHandler) t -> {


            currentLocale = new Locale("ru", "RU");

            String noteName = messages.getString("new.note");
            Note note = new Note();
            note.setName(noteName);
            note.setCreationDateTime(LocalDateTime.now());

            TreeItem newNote = new TreeItem<>(note, new FontIcon("ti-notepad:24"));
            getTreeItem().getChildren().add(newNote);
        });

        MenuItem addNoteBookMenuItem = new MenuItem("Add NoteBook"); //todo i18n
        notebookMenu.getItems().add(addNoteBookMenuItem);
        addNoteBookMenuItem.setOnAction((EventHandler) t -> {


            currentLocale = new Locale("ru", "RU");

            String notebookName = messages.getString("new.notebook"); //todo i18ize

            Notebook noteBook = new Notebook();
            noteBook.setName(notebookName);
            noteBook.setCreationTime(LocalDateTime.now());

            TreeItem newNoteBook = new TreeItem<>(noteBook, new FontIcon("ti-agenda:24"));
            getTreeItem().getChildren().add(newNoteBook);
        });
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }
        setText(null);
        setGraphic(textField);
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(getItem().toString());
        setGraphic(getTreeItem().getGraphic());
    }

    @Override
    public void updateItem(NoteTreeItem item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(getTreeItem().getGraphic());
                //if (!getTreeItem().isLeaf() && getTreeItem().getParent() != null) {
                if (getTreeItem().getValue().getType() == NoteTreeItemType.NOTEBOOK) {
                    setContextMenu(noteMenu);
                }
                else {

                }
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setOnKeyReleased(t -> {
            if (t.getCode() == KeyCode.ENTER) {
                //commitEdit(textField.getText());
                getItem().setName(textField.getText());
                commitEdit(getItem());
            } else if (t.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });

    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }



}
