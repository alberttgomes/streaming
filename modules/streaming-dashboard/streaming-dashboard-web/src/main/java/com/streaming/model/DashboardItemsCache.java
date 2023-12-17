package com.streaming.model;

/**
 * @author Albert Gomes Cabral
 */
public class DashboardItemsCache {
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getExternalReferenceCode() {
        return externalReferenceCode;
    }

    public void setExternalReferenceCode(String externalReferenceCode) {
        this.externalReferenceCode = externalReferenceCode;
    }

    public long getInstanceFk() {
        return instanceFk;
    }

    public void setInstanceFk(long instanceFk) {
        this.instanceFk = instanceFk;
    }

    public long getMvccVersion() {
        return mvccVersion;
    }

    public void setMvccVersion(long mvccVersion) {
        this.mvccVersion = mvccVersion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getVocabularyId() {
        return vocabularyId;
    }

    public void setVocabularyId(long vocabularyId) {
        this.vocabularyId = vocabularyId;
    }

    private String categoryName;
    private long categoryId;
    private String colorTheme;
    private long companyId;
    private String externalReferenceCode;
    private long instanceFk;
    private long mvccVersion;
    private String uuid;
    private long vocabularyId;
}
