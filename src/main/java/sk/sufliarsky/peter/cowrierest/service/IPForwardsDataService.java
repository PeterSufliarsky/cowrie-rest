package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.IPForwardData;
import sk.sufliarsky.peter.cowrierest.repository.IPForwardsDataRepository;

import java.util.List;

@Service
public class IPForwardsDataService {

    @Autowired
    IPForwardsDataRepository ipForwardsDataRepository;

    public List<IPForwardData> getIpForwardsDataForSession(String sessionId) {
        return ipForwardsDataRepository.findBySession(sessionId);
    }
}
