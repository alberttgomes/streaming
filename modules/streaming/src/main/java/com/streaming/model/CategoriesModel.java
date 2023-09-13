package com.streaming.model;

/**
 * @author Albert Gomes Cabral
 */
public class CategoriesModel {

    public String getCategoryName() {
        return _categoryName;
    }

    public void setCategoryName(String categoryName) {
        this._categoryName = categoryName;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        this._categoryId = categoryId;
    }

    public long getCategoryVocabulary() {
        return _categoryVocabulary;
    }

    public void setCategoryVocabulary(long categoryVocabulary) {
        this._categoryVocabulary = categoryVocabulary;
    }

    private String _categoryName;

    private long _categoryId;

    private long _categoryVocabulary;

}
