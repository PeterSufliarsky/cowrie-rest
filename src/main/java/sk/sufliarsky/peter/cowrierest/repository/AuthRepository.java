package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.Auth;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<Auth, String> {

    @Query("SELECT a FROM Auth a WHERE a.session = :sessionId")
    List<Auth> findBySessionId(@Param("sessionId") String sessionId);
}
