package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.TTYLog;
import sk.sufliarsky.peter.cowrierest.repository.TTYLogRepository;

import java.util.List;

@Service
public class TTYLogService {

    @Autowired
    TTYLogRepository ttyLogRepository;

    public List<TTYLog> getTTYLogForSession(String serviceId) {
        return ttyLogRepository.findBySession(serviceId);
    }
}
