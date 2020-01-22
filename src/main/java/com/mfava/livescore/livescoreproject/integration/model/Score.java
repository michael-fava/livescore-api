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
public class Score implements Serializable {

    private Integer current;
    private Integer period1;
    private Integer normaltime;
}
