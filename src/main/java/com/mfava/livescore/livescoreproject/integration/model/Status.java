package com.mfava.livescore.livescoreproject.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;

/**
 * @author michaelfava
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "type")
public class Status implements Serializable {

    private Integer code;
    private StatusType type;

    public Status(StatusType type) {
        this.type = type;
    }

    @JsonIgnore
    public boolean isNull() {
        return type == null;
    }
}
