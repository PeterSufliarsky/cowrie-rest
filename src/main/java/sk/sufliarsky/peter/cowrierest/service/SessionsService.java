package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.Session;
import sk.sufliarsky.peter.cowrierest.repository.SessionsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessionsService {

    @Autowired
    private SessionsRepository sessionsRepository;

    public Optional<Session> getSession(String id) {
        return sessionsRepository.findById(id);
    }

    public List<Session> getSessionsFromDay(int year, int month, int dayOfMonth) {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate day = LocalDate.of(year, month, dayOfMonth);
        return sessionsRepository.findFromDay(LocalDateTime.of(day, midnight), LocalDateTime.of(day, midnight).plusDays(1));
    }

    public List<Session> getSessionsFromToday() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now();
        return sessionsRepository.findFromDay(LocalDateTime.of(today, midnight), LocalDateTime.now());
    }

    public List<Session> getSessionsFromYesterday() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now();
        return sessionsRepository.findFromDay(LocalDateTime.of(today, midnight).minusDays(1), LocalDateTime.of(today, midnight));
    }
}
