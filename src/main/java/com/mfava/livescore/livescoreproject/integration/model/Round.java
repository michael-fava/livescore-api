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
@NoArgsConstructor
@AllArgsConstructor
public class Round implements Serializable {

    private Integer round;
}
