package ru.java3000.yandexdrivetodofx.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.java3000.yandexdrivetodofx.entities.Note;
import jakarta.xml.bind.*;
import ru.java3000.yandexdrivetodofx.services.LocalDateAdapter;

import java.time.LocalDateTime;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Notebook {

    @XmlElement
    public String name;
    @XmlElement
    private String description;
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDateTime creationTime;
    @XmlElement
    private List<Note> notes;
    @XmlElement
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
