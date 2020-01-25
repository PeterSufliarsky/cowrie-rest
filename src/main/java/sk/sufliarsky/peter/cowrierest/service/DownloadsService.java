package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.Download;
import sk.sufliarsky.peter.cowrierest.repository.DownloadsRepository;

import java.util.List;

@Service
public class DownloadsService {

    @Autowired
    private DownloadsRepository downloadsRepository;

    public List<Download> getDownloadsForSession(String sessionId) {
        return downloadsRepository.findBySession(sessionId);
    }
}
