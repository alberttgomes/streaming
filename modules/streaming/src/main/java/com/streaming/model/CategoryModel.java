package com.streaming.model;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
public class CategoryModel {

    public Map<Locale, String> getCategoryName() {
        return _categoryName;
    }

    public void setCategoryName(Map<Locale, String> _categoryName) {
        this._categoryName = _categoryName;
    }

    public Map<Locale, String> getCategoryDescription() {
        return _categoryDescription;
    }

    public void setCategoryDescription(Map<Locale, String> _categoryDescription) {
        this._categoryDescription = _categoryDescription;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        this._categoryId = categoryId;
    }

    public String[] getLabels() {
        return _labels;
    }

    public void setLabels(String[] _labels) {
        this._labels = _labels;
    }

    public Date getDateLaunch() {
        return _dateLaunch;
    }

    public void setDateLaunch(Date _dateLaunch) {
        this._dateLaunch = _dateLaunch;
    }

    private Map<Locale, String> _categoryName;

    private Map<Locale, String> _categoryDescription;

    private long _categoryId;

    private String[] _labels;

    private Date _dateLaunch;
}
