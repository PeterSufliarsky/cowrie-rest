package sk.sufliarsky.peter.honeypot.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.honeypot.cowrierest.entity.Session;
import sk.sufliarsky.peter.honeypot.cowrierest.repository.SessionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> findByTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        return sessionRepository.findByTimeRange(startTime, endTime);
    }
}
