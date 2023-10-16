package com.streaming.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.streaming.model.CarouselContentModel;
import com.streaming.model.CategoryModel;
import com.streaming.portlet.StreamingPortlet;
import com.streaming.service.StreamingService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Albert Gomes Cabral
 */
@Component(service = StreamingService.class)
public class StreamingServiceImpl implements StreamingService {

    @Override
    public Object getPortletContent()
            throws JsonProcessingException {

        return _streamingPortlet.getCarouselDataPortlet();
    }

    @Override
    public CategoryModel createSessionCategory(
            String categoryName, String categoryDescription, long categoryId,
            String[] labels, Date dateLaunch) throws Exception {

        CategoryModel categoryModel = new CategoryModel();

        if (categoryId < -1 && categoryName.isEmpty()) {
            return null;
        }

        try {
            categoryModel.setCategoryName(
                    HashMapBuilder.put(
                            Locale.US,
                            categoryName
                    ).build());
            categoryModel.setCategoryDescription(
                    HashMapBuilder.put(
                            Locale.US,
                            categoryDescription
                    ).build());
            categoryModel.setCategoryId(categoryId);
            categoryModel.setLabels(labels);
            categoryModel.setDateLaunch(dateLaunch);
        }
        catch (Exception exception) {
            throw new Exception(exception);
        }

        return categoryModel;
    }

    @Override
    public void processCarouselView(
            List<CarouselContentModel> carouselContentModels) throws IOException {

        try (FileWriter file = new FileWriter("view.jsp")) {

            StringBundler sb = new StringBundler();

            carouselContentModels.forEach(carousel -> {
                sb.append("<div class-name=\"carousel-content-item\" style=\"" +
                        "'background-color':#" + carousel.getColor() + "\">");
                sb.append(StringPool.NEW_LINE);

                sb.append("<h4 class-name=\"carousel-title\">");
                sb.append(StringPool.NEW_LINE);

                if (carousel.getTitle().isEmpty()
                        || carousel.getTitle() == null) {

                    sb.append("<span>Title is null or missing</span>");
                }
                else {
                    sb.append(carousel.getTitle());
                }

                sb.append(StringPool.NEW_LINE);
                sb.append("</h4>");

                sb.append("<p class-name=\"carousel-description\">");
                sb.append(StringPool.NEW_LINE);

                if (carousel.getDescription().isEmpty()
                        || carousel.getDescription() == null) {

                    sb.append("<span>Description is null or missing</span>");
                }
                else {
                    sb.append(carousel.getDescription());
                }

                sb.append(StringPool.NEW_LINE);
                sb.append("</p>");
                sb.append(StringPool.NEW_LINE);

                sb.append("<div class-name=\"carousel-file-entry-img\">");
                sb.append(StringPool.NEW_LINE);

                if (carousel.getFileEntry() == null) {
                    sb.append("<img src='resources\\META-INF\\streaming-frontend\\dft-images\\not-found.png' />");
                }
                else {
                    sb.append("<img src='" + carousel.getFileEntry() + "' alt='image-carousel' />");
                }

                sb.append(StringPool.NEW_LINE);
                sb.append("</div>");
                sb.append(StringPool.NEW_LINE);

                sb.append("<span class-name=\"carousel-date\">" + carousel.getDate() + "</span>");

            });

            file.write(sb.toString());
            file.flush();

        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Reference
    private StreamingPortlet _streamingPortlet;

}