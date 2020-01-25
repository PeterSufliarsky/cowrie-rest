package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.IPForwardData;

import java.util.List;

@Repository
public interface IPForwardsDataRepository extends JpaRepository<IPForwardData, Long> {

    List<IPForwardData> findBySession(String sessionId);
}
