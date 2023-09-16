package com.streaming.model;

/**
 * @author Albert Gomes Cabral
 */
public class CarouselContentModel {

    public String getColor() {
        return _color;
    }

    public void setColor(String color) {
        this._color = color;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        this._date = date;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public String getFieldSet() {
        return _fieldSet;
    }

    public String getFileEntry() {
        return _fileEntry;
    }

    public void setFileEntry(String fileEntry) {
        this._fileEntry = fileEntry;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    private String _color;

    private String _date;

    private String _description;

    private static final String _fieldSet = "Fieldset92342918";

    private String _fileEntry;

    private String _title;

    @Override
    public String toString() {
        return "{ color: '#" +  _color + "', date: '" + _date +
                "', description: '" + _description + "', urlFileEntry: '" + _fileEntry + "', title: '" + _title + "' }";
    }

}