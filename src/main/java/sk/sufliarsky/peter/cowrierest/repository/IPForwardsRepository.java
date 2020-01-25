package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.IPForward;

import java.util.List;

@Repository
public interface IPForwardsRepository extends JpaRepository<IPForward, Long> {

    List<IPForward> findBySession(String sessionId);
}
