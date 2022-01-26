package ru.java3000.opennotefx.entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.java3000.opennotefx.services.LocalDateAdapter;

import java.time.LocalDateTime;
import java.util.UUID;
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Note {

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
    private String caption;
    @XmlElement
    private String shareLink;
    @XmlElement
    private boolean isEncoded;
    @XmlElement
    private String encodingHash;

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
}
