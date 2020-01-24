package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.Params;


@Repository
public interface ParamsRepository extends JpaRepository<Params, String> {

    @Query("SELECT p FROM Params p WHERE p.session = :session")
    Params findBySessionId(@Param("session") String sessionId);
}
