package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.TTYLog;

import java.util.List;

@Repository
public interface TTYLogRepository extends JpaRepository<TTYLog, Long> {

    List<TTYLog> findBySession(String sessionId);
}
