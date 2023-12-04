package com.streaming.service.base;

import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

public interface CarouselItemsDashboardLocalService {
    @Indexable(type = IndexableType.REINDEX)
    CarouselItemsDashboard addCarouselItemsDashboard(
            CarouselItemsDashboard carouselItemsDashboard);

    BasePersistence<CarouselItemsDashboard> getBasePersistence();

    @Indexable(type = IndexableType.REINDEX)
    CarouselItemsDashboard updateCarouselItemsDashboard(
            CarouselItemsDashboard carouselItemsDashboard);
}
