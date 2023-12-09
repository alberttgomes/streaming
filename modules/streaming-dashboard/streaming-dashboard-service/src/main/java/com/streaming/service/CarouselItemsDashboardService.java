package com.streaming.service;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.streaming.exception.*;
import com.streaming.model.CarouselItemsDashboard;

/**
 * @author Albert Gomes Cabral
 */
public interface CarouselItemsDashboardService {
    public void addNewCarouselItem(
            CarouselItemsDashboard carouselItemsDashboard, long groupId, ThemeDisplay themeDisplay)
            throws CarouselItemNotAllowedException, CarouselInvalidFieldItemException, CarouselItemNotFoundException;

    public void deleteCarouselItemById(
            long categoryId, long groupId, ThemeDisplay themeDisplay)
                throws CarouselItemNotAllowedException, CarouselItemDashboardException;;

    public void getCarouselItemById(
            long categoryId, long groupId, ThemeDisplay themeDisplay)
                throws CarouselDashboardManagerNotFoundException, CarouselItemDashboardException;;

    public void getCarouselItemById(long categoryId, long groupId)
            throws CarouselDashboardManagerNotFoundException, CarouselItemDashboardException;;
}
