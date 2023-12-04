package com.streaming.model.impl;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.json.JSON;

import java.util.Date;

public interface CarouselItemsDashboardModel {
    long getPrimaryKey();

    abstract void setPrimaryKey(long primaryKey);

    @JSON
    long getMvccVersion();

    void setMvccVersion(long mvccVersion);

    @JSON
    String getUuid();

    void setUuid(String uuid);

    @JSON
    String getExternalReferenceCode();

    void setExternalReferenceCode(String externalReferenceCode);

    @JSON
    long getStreamingId();

    void setStreamingId(long streamingId);

    @JSON
    long getGroupId();

    void setGroupId(long groupId);

    @JSON
    long getCompanyId();

    void setCompanyId(long companyId);

    @JSON
    long getUserId();

    void setUserId(long userId);

    String getUserUuid();

    void setUserUuid(String userUuid);

    @JSON
    String getUserName();

    void setUserName(String userName);

    @JSON
    Date getCreateDate();

    void setCreateDate(Date createDate);

    @JSON
    Date getModifiedDate();

    void setModifiedDate(Date modifiedDate);

    @JSON
    String getCategory();

    void setCategory(String category);

    @JSON
    String getColorTheme();

    void setColorTheme(String colorTheme);

    @JSON
    String getPriority();

    void setPriority(String priority);

    @JSON
    String getTitle();

    void setTitle(String title);

    @JSON
    String getUser();

    void setUser(String user);

    StagedModelType getStagedModelType();
}
