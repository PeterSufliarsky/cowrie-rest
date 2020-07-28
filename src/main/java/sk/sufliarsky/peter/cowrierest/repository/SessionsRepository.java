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

    @Query("SELECT s FROM Session s WHERE s.startTime >= :dayStart and s.endTime <= :dayEnd order by s.startTime desc")
    List<Session> findFromDay(@Param("dayStart") LocalDateTime dayStart, @Param("dayEnd") LocalDateTime dayEnd);

    @Query("SELECT s FROM Session s JOIN Auth a ON a.session = s WHERE s.startTime >= :dayStart and s.endTime <= :dayEnd and a.success = 1 order by s.startTime desc")
    List<Session> findAuthenticatedFromDay(@Param("dayStart") LocalDateTime dayStart, @Param("dayEnd") LocalDateTime dayEnd);

    @Query("SELECT s FROM Session s JOIN Auth a ON a.session = s WHERE s.startTime >= :dayStart and s.endTime <= :dayEnd group by s.id having max(a.success) = 0 order by s.startTime desc")
    List<Session> findNonAuthenticatedFromDay(@Param("dayStart") LocalDateTime dayStart, @Param("dayEnd") LocalDateTime dayEnd);

    @Query("SELECT s FROM Session s JOIN Input i ON i.session = s WHERE s.startTime >= :dayStart and s.endTime <= :dayEnd group by s.id order by s.startTime desc")
    List<Session> findFromDayWithInput(@Param("dayStart") LocalDateTime dayStart, @Param("dayEnd") LocalDateTime dayEnd);

    @Query("SELECT s FROM Session s JOIN IPForward i ON i.session = s WHERE s.startTime >= :dayStart and s.endTime <= :dayEnd group by s.id order by s.startTime desc")
    List<Session> findFromDayWithIPForward(@Param("dayStart") LocalDateTime dayStart, @Param("dayEnd") LocalDateTime dayEnd);
}
