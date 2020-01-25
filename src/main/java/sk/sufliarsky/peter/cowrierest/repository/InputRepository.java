package sk.sufliarsky.peter.cowrierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.sufliarsky.peter.cowrierest.entity.Input;

import java.util.List;

@Repository
public interface InputRepository extends JpaRepository<Input, Long> {

    List<Input> findBySession(String sessionId);
}
