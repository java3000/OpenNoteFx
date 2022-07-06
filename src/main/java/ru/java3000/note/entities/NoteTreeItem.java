package ru.java3000.note.entities;

public interface NoteTreeItem {
    String name = "";
    NoteTreeItemType type = null;

    NoteTreeItemType getType();
    String getName();
    void setName(String name);

}
