package com.mfava.livescore.livescoreproject.integration;

import com.mfava.livescore.livescoreproject.config.FeignConfig;
import com.mfava.livescore.livescoreproject.integration.model.FeedEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author michaelfava
 */
@FeignClient(name = "livefeedClient", url = "https://raw.githubusercontent.com", configuration = FeignConfig.class)
public interface LiveFeedClient {

    @GetMapping(value = "/techmobilt/interview-tests/master/data/sports.json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<FeedEvent> getLiveFeedEvents();
}
