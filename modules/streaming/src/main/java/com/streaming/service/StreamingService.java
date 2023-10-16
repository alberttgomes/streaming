package com.streaming.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.streaming.model.CarouselContentModel;
import com.streaming.model.CategoryModel;
import org.osgi.annotation.versioning.ProviderType;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
@ProviderType
public interface StreamingService {

    public Object getPortletContent() throws JsonProcessingException;

    public void processCarouselView(
            List<CarouselContentModel> carouselContentModels) throws IOException;

    public CategoryModel createSessionCategory(
            String categoryName, String categoryDescription, long categoryId,
            String[] labels, Date dateLaunch) throws Exception;
}