package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.Input;
import sk.sufliarsky.peter.cowrierest.repository.InputRepository;

import java.util.List;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;

    public List<Input> getInputForSession(String sessionId) {
        return inputRepository.findBySession(sessionId);
    }
}
