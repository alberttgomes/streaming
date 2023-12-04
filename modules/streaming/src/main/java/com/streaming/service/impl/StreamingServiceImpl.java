package com.streaming.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.streaming.model.CarouselContentModel;
import com.streaming.service.StreamingService;
import org.osgi.service.component.annotations.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
@Component(service = StreamingService.class)
public class StreamingServiceImpl implements StreamingService {

    @Override
    public Object getPortletContent()
            throws JsonProcessingException {
        return null;
    }

    @Override
    public void processCarouselView(
            List<CarouselContentModel> carouselContentModels) throws IOException {
        try (FileWriter file = new FileWriter(
                "resources/META-INF/resources/view.jsp")) {
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

                if (carousel.getDescription().isEmpty()) {
                    sb.append("<p class-name=\"carousel-description\">description is null or missing</span>");
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
}