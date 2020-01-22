package com.mfava.livescore.livescoreproject.api;

import com.mfava.livescore.livescoreproject.filter.FeedsFilter;
import com.mfava.livescore.livescoreproject.integration.model.FeedEvent;
import com.mfava.livescore.livescoreproject.integration.model.Status;
import com.mfava.livescore.livescoreproject.integration.model.StatusType;
import com.mfava.livescore.livescoreproject.service.EventsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author michaelfava
 */
@RestController
@RequestMapping("/api")
public class EventsController {

    EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping("/livescore")
    public List<FeedEvent> getEvents(@RequestParam(name = "status", required = false) String status,
                                     @RequestParam(name = "liveStatus", required = false) String liveStatus) {
        return eventsService.getFeeds(FeedsFilter.builder()
                .status(new Status(StatusType.get(status)))
                .liveStatus(liveStatus)
                .build());
    }


}
