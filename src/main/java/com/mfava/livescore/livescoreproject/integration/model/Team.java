package com.mfava.livescore.livescoreproject.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author michaelfava
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team implements Serializable {

    private Integer id;
    private String name;
    private String slug;
    private String gender;
    private List<Team> subTeams;
}
