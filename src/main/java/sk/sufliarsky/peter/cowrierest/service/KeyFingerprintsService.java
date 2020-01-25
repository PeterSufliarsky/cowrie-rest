package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.KeyFingerprint;
import sk.sufliarsky.peter.cowrierest.repository.KeyFingerprintsRepository;

import java.util.List;

@Service
public class KeyFingerprintsService {

    @Autowired
    KeyFingerprintsRepository keyFingerprintsRepository;

    public List<KeyFingerprint> getKeyFingerprintsForSession(String sessionId) {
        return keyFingerprintsRepository.findBySession(sessionId);
    }
}
