package com.mfava.livescore.livescoreproject.cache;

import com.mfava.livescore.livescoreproject.integration.LiveFeedClient;
import com.mfava.livescore.livescoreproject.integration.model.FeedEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author michaelfava
 */
@Service
public class CacheableFeedService {

    LiveFeedClient liveFeedClient;

    public CacheableFeedService(LiveFeedClient liveFeedClient) {
        this.liveFeedClient = liveFeedClient;
    }

    @Cacheable(value = "feedStore")
    public List<FeedEvent> getFeedEvents() {
        return liveFeedClient.getLiveFeedEvents();
    }
}
