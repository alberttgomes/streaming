package com.streaming.model;

/**
 * @author Albert Gomes
 */
public class PreferencesPortletModel {

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long _companyId) {
        this._companyId = _companyId;
    }

    public String getCategoryName() {
        return _categoryName;
    }

    public void setCategoryName(String _categoryName) {
        this._categoryName = _categoryName;
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

    public void setGroupId(long _groupId) {
        this._groupId = _groupId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long _userId) {
        this._userId = _userId;
    }

    public Object getPreferences() {
        return _preferences;
    }

    public void setPreferences(Object _preferences) {
        this._preferences = _preferences;
    }

    private long _companyId;

    private String _categoryName;

    private String _externalReferenceCode;

    private long _groupId;

    private long _userId;

    private Object _preferences;

}
