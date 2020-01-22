package com.mfava.livescore.livescoreproject;

import com.mfava.livescore.livescoreproject.cache.CacheableFeedService;
import com.mfava.livescore.livescoreproject.integration.model.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.given;

/**
 * @author michaelfava
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTests {

    List<FeedEvent> testFeedEvents;

    @LocalServerPort
    private int port;

    @MockBean
    private CacheableFeedService liveFeedClient;

    @BeforeEach
    public void setUp() {
        testFeedEvents = new ArrayList<>();
        RestAssured.baseURI = "http://localhost";
        RestAssured.defaultParser = Parser.JSON;
        for (int i = 0; i < 20; i++) {
            testFeedEvents.add(generateFeedEvent(null));
        }
        Mockito.when(liveFeedClient.getFeedEvents())
                .thenReturn(testFeedEvents);
    }


    @Test
    public void testApiCallNoFilters() {
        final List<FeedEvent> events = Arrays.asList(given()
                .log()
                .all()
                .port(port)
                .accept("application/json")
                .get("/api/livescore")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract().as(FeedEvent[].class));

        Assert.assertTrue(events.size() == 20);
    }


    @Test
    public void testApiCallStatusInProgress() {
        final List<FeedEvent> events = Arrays.asList(given()
                .log()
                .all()
                .port(port)
                .accept("application/json")
                .get("/api/livescore?status=inprogress")
                .then()
                .log()
                .body()
                .statusCode(200)
                .extract().as(FeedEvent[].class));


        Assert.assertTrue(events.size() == 20);

    }

    private FeedEvent generateFeedEvent(StatusType statusType) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        Random random = new Random(10000);
        Integer homeId = random.nextInt(10000);
        Integer awayId = random.nextInt(10000);

        Team homeTeam = Team.builder()
                .id(homeId)
                .name("HomeTeam_" + homeId)
                .slug("home_" + homeId)
                .gender("M")
                .subTeams(Collections.emptyList())
                .build();

        Team awayTeam = Team.builder()
                .id(awayId)
                .name("AwayTeam_" + awayId)
                .slug("away_" + awayId)
                .gender("M")
                .subTeams(Collections.emptyList())
                .build();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime gameTime = LocalDateTime.of(now.getYear(), now.getMonth(), new Random().nextInt(27) + 1, 21, 0);
        float gameTimestamp = gameTime.toInstant(ZoneOffset.UTC).getEpochSecond() * 1000;

        return FeedEvent.builder()
                .id(RandomStringUtils.random(7))
                .name(homeTeam.getName() + " - " + awayTeam.getName())
                .competitionId("ge")
                .competition("Ekstaklasa")
                .countryId("eh")
                .country("Poland")
                .timestamp(gameTimestamp)
                .date(gameTime.toLocalDate().format(dateFormatter))
                .time(gameTime.toLocalTime().format(timeFormatter))
                .status(Status.builder()
                        .code(new Random().nextInt(100))
                        .type(statusType != null ? statusType : StatusType.INPROGRESS)
                        .build())
                .round(Round.builder()
                        .round(new Random().nextInt(20))
                        .build())
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .homeScore(generateScore(1, 0))
                .awayScore(generateScore(0, 0))
                .liveStatus("HT")
                .build();
    }

    private Score generateScore(int current, int period1) {
        return Score.builder()
                .current(current)
                .period1(period1)
                .build();
    }


}
