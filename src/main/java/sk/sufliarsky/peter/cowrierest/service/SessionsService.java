package sk.sufliarsky.peter.cowrierest.service;

import com.maxmind.geoip2.record.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${geolite2.asn.enabled}")
    private Boolean geoLite2AsnEnabled;

    @Value("${geolite2.countries.enabled}")
    private Boolean geoLite2CountriesEnabled;

    @Autowired
    private SessionsRepository sessionsRepository;

    @Autowired
    private GeoIpService geoIpService;

    private void addGeoIpInformation(List<Session> sessions) {
        // Add ASN information from the GeoIP database
        if (geoLite2AsnEnabled) {
            for (Session s: sessions) {
                Integer asnId = geoIpService.getAsnId(s.getIp());
                String asnName = geoIpService.getAsnName(s.getIp());
                s.setAsnId(asnId);
                s.setAsnName(asnName);
            }
        }

        // Add country information from the GetIP database
        if (geoLite2CountriesEnabled) {
            for (Session s: sessions) {
                Country country = geoIpService.getCountryInformation(s.getIp());
                s.setCountry(country.getIsoCode());
            }
        }
    }

    public Optional<Session> getSession(String id) {
        return sessionsRepository.findById(id);
    }

    public List<Session> getSessionsFromDay(
            int year,
            int month,
            int dayOfMonth,
            AuthResultEnum authResult,
            ActivityEnum activity) {

        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate day = LocalDate.of(year, month, dayOfMonth);
        List<Session> sessions;

        // AuthResult.PASS
        if (AuthResultEnum.PASS.equals(authResult)) {
            if (ActivityEnum.INPUT.equals(activity)) {
                sessions = sessionsRepository.findFromTimeRangeWithInput(
                        LocalDateTime.of(day, midnight),
                        LocalDateTime.of(day, midnight).plusDays(1)
                );
            } else if (ActivityEnum.IPFORWARD.equals(activity)) {
		        sessions = sessionsRepository.findFromTimeRangeWithIPForward(
		                LocalDateTime.of(day, midnight),
                        LocalDateTime.of(day, midnight).plusDays(1)
                );
            } else {
                sessions = sessionsRepository.findAuthenticatedFromTimeRange(
                        LocalDateTime.of(day, midnight),
                        LocalDateTime.of(day, midnight).plusDays(1)
                );
            }
        // AuthResult.FAIL
        } else if (AuthResultEnum.FAIL.equals(authResult)) {
            sessions = sessionsRepository.findNonAuthenticatedFromTimeRange(
                    LocalDateTime.of(day, midnight),
                    LocalDateTime.of(day, midnight).plusDays(1)
            );
        // AuthResult.ANY
        } else {
            if (ActivityEnum.INPUT.equals(activity)) {
		        sessions = sessionsRepository.findFromTimeRangeWithInput(
		                LocalDateTime.of(day, midnight),
                        LocalDateTime.of(day, midnight).plusDays(1)
                );
            } else if (ActivityEnum.IPFORWARD.equals(activity)) {
		        sessions = sessionsRepository.findFromTimeRangeWithIPForward(
		                LocalDateTime.of(day, midnight),
                        LocalDateTime.of(day, midnight).plusDays(1)
                );
            } else {
		        sessions = sessionsRepository.findFromTimeRange(
		                LocalDateTime.of(day, midnight),
                        LocalDateTime.of(day, midnight).plusDays(1)
                );
	        }
        }

        addGeoIpInformation(sessions);

        return sessions;
    }

    public List<Session> getSessionsFromTimeRange(
            LocalDateTime startTime,
            LocalDateTime endTime,
            AuthResultEnum authResult,
            ActivityEnum activity) {

        List<Session> sessions;

        // AuthResult.PASS
        if (AuthResultEnum.PASS.equals(authResult)) {
            if (ActivityEnum.INPUT.equals(activity)) {
                sessions = sessionsRepository.findFromTimeRangeWithInput(startTime, endTime);
            } else if (ActivityEnum.IPFORWARD.equals(activity)) {
                sessions = sessionsRepository.findFromTimeRangeWithIPForward(startTime, endTime);
            } else {
                sessions = sessionsRepository.findAuthenticatedFromTimeRange(startTime, endTime);
            }
            // AuthResult.FAIL
        } else if (AuthResultEnum.FAIL.equals(authResult)) {
            sessions = sessionsRepository.findNonAuthenticatedFromTimeRange(startTime, endTime);
            // AuthResult.ANY
        } else {
            if (ActivityEnum.INPUT.equals(activity)) {
                sessions = sessionsRepository.findFromTimeRangeWithInput(startTime, endTime);
            } else if (ActivityEnum.IPFORWARD.equals(activity)) {
                sessions = sessionsRepository.findFromTimeRangeWithIPForward(startTime, endTime);
            } else {
                sessions = sessionsRepository.findFromTimeRange(startTime, endTime);
            }
        }

        addGeoIpInformation(sessions);

        return sessions;
    }

    public List<Session> getSessionsFromToday(AuthResultEnum authResult, ActivityEnum activity) {
        LocalDate today = LocalDate.now();

	    return getSessionsFromDay(
	            today.getYear(),
                today.getMonthValue(),
                today.getDayOfMonth(),
                authResult,
                activity
        );
    }

    public List<Session> getSessionsFromYesterday(AuthResultEnum authResult, ActivityEnum activity) {
        LocalDate yesterday = LocalDate.now().minusDays(1);

        return getSessionsFromDay(
                yesterday.getYear(),
                yesterday.getMonthValue(),
                yesterday.getDayOfMonth(),
                authResult, activity
        );
    }

}
