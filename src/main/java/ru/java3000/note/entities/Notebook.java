package ru.java3000.note.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.java3000.note.services.LocalDateAdapter;

import java.time.LocalDateTime;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Notebook implements NoteTreeItem {

    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDateTime creationTime;
    @XmlElement
    private int order;
    @XmlElement
    private List<Note> notes;
    @XmlElement
    private String shareLink;
    @XmlElement
    private String localLocation;
    @XmlElement
    private String remoteLocation;
    @XmlElement
    private boolean isInTrash;

    private NoteTreeItemType type = NoteTreeItemType.NOTEBOOK;

    public Notebook() {
    }

    public Notebook(String name, String description, LocalDateTime creationTime, int order, List<Note> notes,
                    String shareLink, String localLocation, String remoteLocation) {
        this.name = name;
        this.description = description;
        this.creationTime = LocalDateTime.now();
        this.order = order;
        this.notes = notes;
        this.shareLink = shareLink;
        this.localLocation = localLocation;
        this.remoteLocation = remoteLocation;
        this.isInTrash = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getLocalLocation() {
        return localLocation;
    }

    public void setLocalLocation(String localLocation) {
        this.localLocation = localLocation;
    }

    public String getRemoteLocation() {
        return remoteLocation;
    }

    public void setRemoteLocation(String remoteLocation) {
        this.remoteLocation = remoteLocation;
    }

    public boolean isInTrash() {
        return isInTrash;
    }

    public void setInTrash(boolean inTrash) {
        isInTrash = inTrash;
    }

    public NoteTreeItemType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
