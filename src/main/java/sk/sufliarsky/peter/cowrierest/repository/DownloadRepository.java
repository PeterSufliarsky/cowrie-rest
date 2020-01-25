package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.Download;

import java.util.List;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Long> {

    List<Download> findBySession(String sessionId);
}
