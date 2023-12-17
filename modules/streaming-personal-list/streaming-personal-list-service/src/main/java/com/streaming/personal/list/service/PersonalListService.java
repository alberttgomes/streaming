package com.streaming.personal.list.service;

import com.liferay.portal.kernel.transaction.Transactional;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;

@ProviderType
@Transactional
public interface PersonalListService {
    public void addItemToPersonalList(
            long companyId, Date createDate, Date modifiedDate, String description,
            String fileShort, boolean launch, String userName, String uuid,
            long personItemId, long groupId, long instancePk, String title)
                throws Exception;

}
