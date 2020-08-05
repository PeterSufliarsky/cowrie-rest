package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.Session;
import sk.sufliarsky.peter.cowrierest.enums.ActivityEnum;
import sk.sufliarsky.peter.cowrierest.enums.AuthResultEnum;
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

    public List<Session> getSessionsFromDay(int year, int month, int dayOfMonth, AuthResultEnum authResult, ActivityEnum activity) {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate day = LocalDate.of(year, month, dayOfMonth);

        // AuthResult.PASS
        if (AuthResultEnum.PASS.equals(authResult)) {
            if (ActivityEnum.INPUT.equals(activity)) {
                return sessionsRepository.findFromTimeRangeWithInput(LocalDateTime.of(day, midnight), LocalDateTime.of(day, midnight).plusDays(1));
            } else if (ActivityEnum.IPFORWARD.equals(activity)) {
		        return sessionsRepository.findFromTimeRangeWithIPForward(LocalDateTime.of(day, midnight), LocalDateTime.of(day, midnight).plusDays(1));
            } else {
                return sessionsRepository.findAuthenticatedFromTimeRange(LocalDateTime.of(day, midnight), LocalDateTime.of(day, midnight).plusDays(1));
            }
        // AuthResult.FAIL
        } else if (AuthResultEnum.FAIL.equals(authResult)) {
            return sessionsRepository.findNonAuthenticatedFromTimeRange(LocalDateTime.of(day, midnight), LocalDateTime.of(day, midnight).plusDays(1));
        // AuthResult.ANY
        } else {
            if (ActivityEnum.INPUT.equals(activity)) {
		        return sessionsRepository.findFromTimeRangeWithInput(LocalDateTime.of(day, midnight), LocalDateTime.of(day, midnight).plusDays(1));
            } else if (ActivityEnum.IPFORWARD.equals(activity)) {
		        return sessionsRepository.findFromTimeRangeWithIPForward(LocalDateTime.of(day, midnight), LocalDateTime.of(day, midnight).plusDays(1));
            } else {
		        return sessionsRepository.findFromTimeRange(LocalDateTime.of(day, midnight), LocalDateTime.of(day, midnight).plusDays(1));
	        }
        }
    }

    public List<Session> getSessionsFromToday(AuthResultEnum authResult, ActivityEnum activity) {
        LocalDate today = LocalDate.now();
	
	    return getSessionsFromDay(today.getYear(), today.getMonthValue(), today.getDayOfMonth(), authResult, activity);
    }

    public List<Session> getSessionsFromYesterday(AuthResultEnum authResult, ActivityEnum activity) {
        LocalDate yesterday = LocalDate.now().minusDays(1);

        return getSessionsFromDay(yesterday.getYear(), yesterday.getMonthValue(), yesterday.getDayOfMonth(), authResult, activity);
    }
}
