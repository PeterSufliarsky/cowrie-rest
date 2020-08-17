package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.Download;
import sk.sufliarsky.peter.cowrierest.repository.DownloadsRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DownloadsService {

    @Autowired
    private DownloadsRepository downloadsRepository;

    @Value("${cowrie.path}")
    private String cowriePath;

    @Value("${cowrie.downloads.path}")
    private String downloadsPath;

    public List<Download> getDownloadsForSession(String sessionId) {
        return downloadsRepository.findBySession(sessionId);
    }

    public ResponseEntity<Resource> getDownloadedFile(String hash) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        File file = new File(cowriePath + '/' + downloadsPath + '/' + hash);
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
	}
}
