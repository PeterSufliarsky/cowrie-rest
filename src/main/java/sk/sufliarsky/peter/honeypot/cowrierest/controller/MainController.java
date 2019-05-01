package sk.sufliarsky.peter.honeypot.cowrierest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sk.sufliarsky.peter.honeypot.cowrierest.entity.Session;
import sk.sufliarsky.peter.honeypot.cowrierest.service.SessionService;

import java.time.Instant;
import java.time.ZoneId;

@Controller
@RequestMapping(path="/api")
public class MainController {

    @Autowired
    private SessionService sessionService;

    @GetMapping(path=("/session"))
    public @ResponseBody Iterable<Session> findSessionsInTimeRange(@RequestParam Long startTime, @RequestParam Long endTime) {
        Instant start = Instant.ofEpochSecond(startTime);
        Instant end = Instant.ofEpochSecond(endTime);

        return sessionService.findByTimeRange(
                start.atZone(ZoneId.of("UTC")).toLocalDateTime(),
                end.atZone(ZoneId.of("UTC")).toLocalDateTime()
        );
    }
}
