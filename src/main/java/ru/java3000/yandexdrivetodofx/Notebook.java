package ru.java3000.yandexdrivetodofx;

import java.time.LocalDateTime;
import java.util.List;

public class Notebook {

    private String name;
    private String description;
    private LocalDateTime creationTime;
    private List<Note> notes;
    private String shareLink;

    public Notebook() {
    }

    public Notebook(String name, String description, LocalDateTime creationTime, List<Note> notes, String shareLink) {
        this.name = name;
        this.description = description;
        this.creationTime = creationTime;
        this.notes = notes;
        this.shareLink = shareLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    @Override
    public String toString() {
        return name;
    }
}
