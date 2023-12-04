package com.streaming.model.impl;

import java.util.Date;

public interface CarouselItemsDashboard {
    String getTitle();

    long getMvccVersion();

    void setMvccVersion(Long aLong);

    Object getUuid();

    void setUuid(String s);

    long getPrimaryKey();

    Object getExternalReferenceCode();

    void setExternalReferenceCode(String s);

    long getStreamingId();

    void setStreamingId(Long aLong);

    Object getGroupId();

    void setGroupId(Long aLong);

    Object getCompanyId();

    void setCompanyId(Long aLong);

    Object getUserId();

    void setUserId(Long aLong);

    Object getUserName();

    void setUserName(String s);

    Object getCreateDate();

    void setCreateDate(Date date);

    void setUser(String s);

    Object getUser();

    void setTitle(String s);

    void setPriority(String s);

    Object getPriority();

    void setColorTheme(String s);

    Object getColorTheme();

    Object getCategory();

    void setCategory(String s);

    void setModifiedDate(Date date);

    Object getModifiedDate();
}
