package com.streaming.service;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.streaming.exception.*;
import com.streaming.model.CarouselItemsDashboard;

import java.util.Date;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
public interface StreamingDashboardCarouselManagerService {
    public void addNewCarouselItem(
            long mvccVersion, String uuid, String externalReferenceCode, long categoryId,
            long groupId, long companyId, String userName, Date createDate, Date modifiedDate,
            String category, String colorTheme, long instanceCategoryFk, String priority,
            String title, ThemeDisplay themeDisplay) throws CarouselItemNotAllowedException,
            CarouselInvalidFieldItemException, CarouselItemNotFoundException;

    public void deleteCarouselItemById(
                long categoryId, long groupId, ThemeDisplay themeDisplay)
            throws CarouselItemNotAllowedException, CarouselItemDashboardException,
            NoSuchCarouselItemsDashboardException;;

    public CarouselItemsDashboard getCarouselItemById(
                long categoryId, long groupId, ThemeDisplay themeDisplay)
            throws CarouselDashboardManagerNotFoundException, CarouselItemDashboardException,
            NoSuchCarouselItemsDashboardException, CarouselItemNotAllowedException;;

    public List<CarouselItemsDashboard> getCarouselItemsList(long groupId) throws
            CarouselDashboardManagerNotFoundException, CarouselItemDashboardException;

    public CarouselItemsDashboard updateCarouselItemById(
            long categoryId, long groupId,  String userName, String category,
            String colorTheme, String priority, String title)
          throws CarouselDashboardManagerNotFoundException, CarouselItemDashboardException;
}
