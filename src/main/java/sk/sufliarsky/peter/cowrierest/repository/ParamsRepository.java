package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.Params;


@Repository
public interface ParamsRepository extends JpaRepository<Params, Long> {

    Params findBySession(String sessionId);
}
