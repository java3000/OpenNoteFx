package ru.java3000.yandexdrivetodofx;

import java.time.LocalDateTime;
import java.util.UUID;

public class Note {

    private UUID deviceID;
    private UUID notebookID;
    private LocalDateTime creationDateTime;
    private LocalDateTime sheduledDateTime;
    private long version;
    private String text;
    private String caption;
    private String shareLink;

    public Note() {
    }

    public Note(UUID deviceID, UUID notebookID, LocalDateTime creationDateTime, long version, String text) {
        this.deviceID = deviceID;
        this.notebookID = notebookID;
        this.creationDateTime = creationDateTime;
        this.version = version;
        this.text = text;
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
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }
}
