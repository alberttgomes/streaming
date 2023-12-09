package com.streaming.service.impl.util;

/**
 * @author Albert Gomes Cabral
 */
public enum PrioritiesEnum {
    HIGH_PRIORITY,

    MIDDLE_PRIORITY,

    LOW_PRIORITY,

    DEACTIVATED;

    public static String[] valuesArray () {
        return new String[] {
                HIGH_PRIORITY.toString(),
                MIDDLE_PRIORITY.toString(),
                LOW_PRIORITY.toString()
        };
    }
}
