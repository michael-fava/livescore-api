package com.mfava.livescore.livescoreproject.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author michaelfava
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedEvent implements Serializable {

    private String id;
    private String name;
    private String competitionId;
    private String competition;
    private String countryId;
    private String country;
    private float timestamp;
    private String date;
    private String time;
    private Status status;
    private Round round;
    private Team homeTeam;
    private Team awayTeam;
    private Score homeScore;
    private Score awayScore;
    private String liveStatus;
}
