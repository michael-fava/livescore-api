package com.mfava.livescore.livescoreproject.service;

import com.mfava.livescore.livescoreproject.cache.CacheableFeedService;
import com.mfava.livescore.livescoreproject.filter.FeedsFilter;
import com.mfava.livescore.livescoreproject.integration.model.FeedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author michaelfava
 */
@Service
public class EventsService {

    CacheableFeedService cacheableFeedService;

    public EventsService(CacheableFeedService cacheableFeedService) {
        this.cacheableFeedService = cacheableFeedService;
    }

    public List<FeedEvent> getFeeds(FeedsFilter filter) {
        return cacheableFeedService.getFeedEvents().stream()
                .filter(filter.toPredicate())
                .collect(Collectors.toList());
    }


}
