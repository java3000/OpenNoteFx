package ru.java3000.note.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.java3000.note.services.LocalDateAdapter;

import java.time.LocalDateTime;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Note implements NoteTreeItem {

    @XmlElement
    private UUID deviceID;
    @XmlElement
    private UUID notebookID;
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDateTime creationDateTime;
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDateTime sheduledDateTime;
    @XmlElement
    private long version;
    @XmlElement
    private int order;
    @XmlElement
    public String text;
    @XmlElement
    private String name;
    @XmlElement
    private String shareLink;
    @XmlElement
    private boolean isEncoded;
    @XmlElement
    private String encodingHash;

    private NoteTreeItemType type = NoteTreeItemType.NOTE;

    public Note() {
    }

    public Note(UUID deviceID, UUID notebookID, LocalDateTime creationDateTime, long version, String text, boolean isEncoded, String encodingHash, int order) {
        this.deviceID = deviceID;
        this.notebookID = notebookID;
        this.creationDateTime = creationDateTime;
        this.version = version;
        this.text = text;
        this.isEncoded = isEncoded;
        this.encodingHash = encodingHash;
        this.order = order;
    }

    public UUID getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(UUID deviceID) {
        this.deviceID = deviceID;
    }

    public UUID getNotebookID() {
        return notebookID;
    }

    public void setNotebookID(UUID notebookID) {
        this.notebookID = notebookID;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getSheduledDateTime() {
        return sheduledDateTime;
    }

    public void setSheduledDateTime(LocalDateTime sheduledDateTime) {
        this.sheduledDateTime = sheduledDateTime;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCaption() {
        return name;
    }

    @Override
    public void setName(String caption) {
        this.name = caption;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public boolean isEncoded() {
        return isEncoded;
    }

    public void setEncoded(boolean encoded) {
        isEncoded = encoded;
    }

    public String getEncodingHash() {
        return encodingHash;
    }

    public void setEncodingHash(String encodingHash) {
        this.encodingHash = encodingHash;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public NoteTreeItemType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
