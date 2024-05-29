package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.Session;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionsRepository extends JpaRepository<Session, String> {

    @Query("SELECT s FROM Session s WHERE s.startTime >= :startTime and s.endTime <= :endTime order by s.startTime desc")
    List<Session> findFromTimeRange(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT s FROM Session s JOIN Auth a ON s.id = a.session WHERE s.startTime >= :startTime and s.endTime <= :endTime and a.success = 1 order by s.startTime desc")
    List<Session> findAuthenticatedFromTimeRange(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT s FROM Session s JOIN Auth a ON s.id = a.session WHERE s.startTime >= :startTime and s.endTime <= :endTime group by s.id having max(a.success) = 0 order by s.startTime desc")
    List<Session> findNonAuthenticatedFromTimeRange(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT s FROM Session s JOIN Input i ON s.id = i.session WHERE s.startTime >= :startTime and s.endTime <= :endTime group by s.id order by s.startTime desc")
    List<Session> findFromTimeRangeWithInput(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT s FROM Session s JOIN IPForward i ON s.id = i.session WHERE s.startTime >= :startTime and s.endTime <= :endTime group by s.id order by s.startTime desc")
    List<Session> findFromTimeRangeWithIPForward(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
