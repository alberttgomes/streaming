package com.streaming.util;

import com.streaming.constants.StreamingCategoriesKeys;

/**
 * @author Albert Gomges Cabral
 */
public class StreamingPortletUtil {
    public static String[] streamingVocabularyValuesToArray() {
        return new String[] {
                StreamingCategoriesKeys.STREAMING_LAUNCH_CATEGORY,
                StreamingCategoriesKeys.STREAMING_HEROES_CATEGORY,
                StreamingCategoriesKeys.STREAMING_KIDS_CATEGORY,
                StreamingCategoriesKeys.STREAMING_SERIES_CATEGORY,
                StreamingCategoriesKeys.STREAMING_MOVIES_CATEGORY
        };
    }
}
