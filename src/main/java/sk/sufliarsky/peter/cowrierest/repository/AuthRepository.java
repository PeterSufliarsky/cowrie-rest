package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.Auth;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {

    List<Auth> findBySession(String sessionId);
}
