package ru.java3000.note.services;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;

public class LocalDateAdapter extends XmlAdapter<String, LocalDateTime>
{
    @Override
    public String marshal(LocalDateTime date)
    {
        if ( date == null ) return null;
        return date.toString();
    }

    @Override
    public LocalDateTime unmarshal(String string)
    {
        return LocalDateTime.parse(string);
    }
}
