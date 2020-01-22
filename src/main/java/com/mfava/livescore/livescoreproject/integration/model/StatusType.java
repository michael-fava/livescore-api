package com.mfava.livescore.livescoreproject.integration.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

/**
 * @author michaelfava
 */
public enum StatusType {
    INPROGRESS("inprogress"),
    NOTSTARTED("notstarted"),
    FINISHED("finished"),
    CANCELLED("canceled");

    private String statusType;

    StatusType(String statusType) {
        this.statusType = statusType;
    }

    @JsonCreator
    public static StatusType get(String statusType) {
        return Arrays.stream(values())
                .filter(value -> value.statusType.equalsIgnoreCase(statusType))
                .findFirst()
                .orElse(null);
    }

}
