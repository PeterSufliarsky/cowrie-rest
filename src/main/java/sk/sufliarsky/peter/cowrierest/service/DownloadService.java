package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.Download;
import sk.sufliarsky.peter.cowrierest.repository.DownloadRepository;

import java.util.List;

@Service
public class DownloadService {

    @Autowired
    private DownloadRepository downloadRepository;

    public List<Download> getDownloadsForSession(String sessionId) {
        return downloadRepository.findBySession(sessionId);
    }
}
