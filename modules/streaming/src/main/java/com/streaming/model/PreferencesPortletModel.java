package com.streaming.model;

/**
 * @author Albert Gomes
 */
public class PreferencesPortletModel {

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        this._companyId = companyId;
    }

    public String getExternalReferenceCode(){
        return _externalReferenceCode;
    }

    public void setExternalReferenceCode(String externalReferenceCode) {
        this._externalReferenceCode = externalReferenceCode;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        this._groupId = groupId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        this._userId = userId;
    }

    public Object getPreferences() {
        return _preferences;
    }

    public void setPreferences(Object preferences) {
        this._preferences = preferences;
    }

    public long getMvccVersion() {
        return _mvccVersion;
    }

    public void setMvccVersion(long mvccVersion) {
        this._mvccVersion = mvccVersion;
    }

    public String getVocabularyCategories() {
        return _vocabularyCategories;
    }

    public void setVocabularyCategories(String vocabularyCategories) {
        this._vocabularyCategories = vocabularyCategories;
    }

    private long _companyId;

    private String _externalReferenceCode;

    private long _groupId;

    private long _mvccVersion;

    private long _userId;

    private Object _preferences;

    private String _vocabularyCategories;

}
