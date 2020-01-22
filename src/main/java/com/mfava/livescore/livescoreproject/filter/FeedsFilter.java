package com.mfava.livescore.livescoreproject.filter;

import com.mfava.livescore.livescoreproject.integration.model.FeedEvent;
import com.mfava.livescore.livescoreproject.integration.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.function.Predicate;


/**
 * @author michaelfava
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedsFilter {

    private Status status;

    private String liveStatus;

    public Predicate<FeedEvent> toPredicate() {
        return el -> (status.isNull() || el.getStatus().equals(status))
                && (Strings.isBlank(liveStatus) || el.getLiveStatus().equalsIgnoreCase(liveStatus));
    }

}
