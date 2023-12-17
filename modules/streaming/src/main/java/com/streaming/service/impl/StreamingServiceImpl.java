package com.streaming.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.streaming.exceptions.StreamingException;
import com.streaming.model.ContentModel;
import com.streaming.model.PreferencesPortletModel;
import com.streaming.portlet.StreamingPortlet;
import com.streaming.service.StreamingService;
import org.osgi.service.component.annotations.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
@Component(service = StreamingService.class)
public class StreamingServiceImpl
        extends StreamingPortlet implements StreamingService {

    @Override
    public Map<String, ContentModel> getPortletContent()
            throws JsonProcessingException, StreamingException {
        List<ContentModel> contentModelList = new ArrayList<>();
        return null;
    }

    @Override
    public void processCarouselContentView(
            List<ContentModel> contentModels) throws IOException, StreamingException {
        try (FileWriter file = new FileWriter(
                "resources/META-INF/resources/view.jsp")) {
            StringBundler sb = new StringBundler();

            contentModels.forEach(carousel -> {
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
        catch (StreamingException streamingException) {
            throw new StreamingException(
                    "Allowed denied to restrict area application, try again. ",
                    streamingException);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public PreferencesPortletModel preferencesPortlet(
            long companyId, String externalReferenceCode, long preferenceId) {
        return null;
    }

    private static final Log _log = LogFactoryUtil.getLog(
            StreamingServiceImpl.class);
}