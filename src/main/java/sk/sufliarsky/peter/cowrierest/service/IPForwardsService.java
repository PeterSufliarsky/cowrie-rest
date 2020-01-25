package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.IPForward;
import sk.sufliarsky.peter.cowrierest.repository.IPForwardsRepository;

import java.util.List;

@Service
public class IPForwardsService {

    @Autowired
    IPForwardsRepository ipForwardsRepository;

    public List<IPForward> getIpForwardsForSession(String sessionId) {
        return ipForwardsRepository.findBySession(sessionId);
    }
}
