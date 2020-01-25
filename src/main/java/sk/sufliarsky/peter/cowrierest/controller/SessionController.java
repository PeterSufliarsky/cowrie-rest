package sk.sufliarsky.peter.cowrierest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.sufliarsky.peter.cowrierest.entity.*;
import sk.sufliarsky.peter.cowrierest.service.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/sessions")
public class SessionController {

    @Autowired
    private AuthService authService;

    @Autowired
    private DownloadService downloadService;

    @Autowired
    KeyFingerprintsService keyFingerprintsService;

    @Autowired
    private ParamsService paramsService;

    @Autowired
    private SessionService sessionService;

    @GetMapping(path=("/{id}"))
    public @ResponseBody Optional<Session> getSession(@PathVariable String id) {
        return sessionService.getSession(id);
    }

    @GetMapping(path=(""))
    public @ResponseBody
    List<Session> getSessionsFromDay(@RequestParam String date) {
        if ("today".equals(date)) {
            return sessionService.getSessionsFromToday();
        } else if ("yesterday".equals(date)) {
            return sessionService.getSessionsFromYesterday();
        } else if (date != null && date.length() == 8) {
            try {
                int year = Integer.parseInt(date.substring(0, 4));
                int month = Integer.parseInt(date.substring(4, 6));
                int dayOfMonth = Integer.parseInt(date.substring(6, 8));
                return sessionService.getSessionsFromDay(year, month, dayOfMonth);
            } catch (NumberFormatException ex) {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }

    }

    @GetMapping(path=("/{id}/auth"))
    public @ResponseBody List<Auth> getAuth(@PathVariable String id) {
        return authService.getAuthForSession(id);
    }

    @GetMapping(path=("/{id}/keyfingerprints"))
    public @ResponseBody List<KeyFingerprint> getKeyFingerprints(@PathVariable String id) {
        return keyFingerprintsService.getKeyFingerprintsForSession(id);
    }

    @GetMapping(path=("/{id}/params"))
    public @ResponseBody Params getParams(@PathVariable String id) {
        return paramsService.getParamsForSession(id);
    }

    @GetMapping(path=("/{id}/downloads"))
    public @ResponseBody
    List<Download> getDownloads(@PathVariable String id) {
        return downloadService.getDownloadsForSession(id);
    }
}
