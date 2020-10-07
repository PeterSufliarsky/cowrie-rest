package sk.sufliarsky.peter.cowrierest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.sufliarsky.peter.cowrierest.service.DownloadsService;

import java.io.IOException;

@RestController
@RequestMapping(path="/downloads")
public class DownloadsController {

    @Autowired
    private DownloadsService downloadsService;

    @GetMapping(path=("/{hash:[a-fA-F0-9]{64}}"))
    public ResponseEntity<Resource> getDownload(@PathVariable String hash) throws IOException {
        return downloadsService.getDownloadedFile(hash);
    }
}
