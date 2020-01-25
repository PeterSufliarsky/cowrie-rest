package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.KeyFingerprint;

import java.util.List;

@Repository
public interface KeyFingerprintsRepository extends JpaRepository<KeyFingerprint, Long> {

    List<KeyFingerprint> findBySession(String sessionId);
}
