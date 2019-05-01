package sk.sufliarsky.peter.honeypot.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.honeypot.cowrierest.entity.Session;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

    @Query(value = "from Session t where starttime BETWEEN :startTime AND :endTime")
    List<Session> findByTimeRange(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
