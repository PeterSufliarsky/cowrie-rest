package sk.sufliarsky.peter.cowrierest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.sufliarsky.peter.cowrierest.entity.*;
import sk.sufliarsky.peter.cowrierest.enums.ActivityEnum;
import sk.sufliarsky.peter.cowrierest.enums.AuthResultEnum;
import sk.sufliarsky.peter.cowrierest.service.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/sessions")
public class SessionController {

    @Autowired
    private AuthService authService;

    @Autowired
    private DownloadsService downloadsService;

    @Autowired
    InputService inputService;

    @Autowired
    IPForwardsService ipForwardsService;

    @Autowired
    IPForwardsDataService ipForwardsDataService;

    @Autowired
    KeyFingerprintsService keyFingerprintsService;

    @Autowired
    private ParamsService paramsService;

    @Autowired
    private SessionsService sessionsService;

    @Autowired
    private TTYLogService ttyLogService;

    @GetMapping(path=("/{id}"))
    public Optional<Session> getSession(@PathVariable String id) {
        return sessionsService.getSession(id);
    }

    @GetMapping(path=(""))
    public List<Session> getSessionsFromDay(@RequestParam String date, @RequestParam(defaultValue = "any") AuthResultEnum authResult, @RequestParam(defaultValue = "any") ActivityEnum activity) {
        if ("today".equals(date)) {
            return sessionsService.getSessionsFromToday(authResult, activity);
        } else if ("yesterday".equals(date)) {
            return sessionsService.getSessionsFromYesterday(authResult, activity);
        } else if (date != null && date.length() == 8) {
            try {
                int year = Integer.parseInt(date.substring(0, 4));
                int month = Integer.parseInt(date.substring(4, 6));
                int dayOfMonth = Integer.parseInt(date.substring(6, 8));
                return sessionsService.getSessionsFromDay(year, month, dayOfMonth, authResult, activity);
            } catch (NumberFormatException ex) {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }

    }

    @GetMapping(path=("/{id}/auth"))
    public List<Auth> getAuth(@PathVariable String id) {
        return authService.getAuthForSession(id);
    }

    @GetMapping(path=("/{id}/downloads"))
    public List<Download> getDownloads(@PathVariable String id) {
        return downloadsService.getDownloadsForSession(id);
    }

    @GetMapping(path=("/{id}/input"))
    public List<Input> getInput(@PathVariable String id) {
        return inputService.getInputForSession(id);
    }

    @GetMapping(path=("/{id}/ipforwards"))
    public List<IPForward> getIpForwards(@PathVariable String id) {
        return ipForwardsService.getIpForwardsForSession(id);
    }

    @GetMapping(path=("/{id}/ipforwardsdata"))
    public List<IPForwardData> getIpForwardsData(@PathVariable String id) {
        return ipForwardsDataService.getIpForwardsDataForSession(id);
    }

    @GetMapping(path=("/{id}/keyfingerprints"))
    public List<KeyFingerprint> getKeyFingerprints(@PathVariable String id) {
        return keyFingerprintsService.getKeyFingerprintsForSession(id);
    }

    @GetMapping(path=("/{id}/params"))
    public List<Params> getParams(@PathVariable String id) {
        return paramsService.getParamsForSession(id);
    }

    @GetMapping(path=("/{id}/ttylog"))
    public List<TTYLog> getTTYLog(@PathVariable String id) {
        return ttyLogService.getTTYLogForSession(id);
    }
}
