package sk.sufliarsky.peter.cowrierest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.sufliarsky.peter.cowrierest.entity.Auth;
import sk.sufliarsky.peter.cowrierest.entity.Session;
import sk.sufliarsky.peter.cowrierest.service.AuthService;
import sk.sufliarsky.peter.cowrierest.service.SessionService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/sessions")
public class SessionController {

    @Autowired
    private AuthService authService;

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
        return authService.findBySessionId(id);
    }
}
