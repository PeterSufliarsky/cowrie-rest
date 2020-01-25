package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.Params;
import sk.sufliarsky.peter.cowrierest.repository.ParamsRepository;

import java.util.List;

@Service
public class ParamsService {

    @Autowired
    private ParamsRepository paramsRepository;

    public List<Params> getParamsForSession(String sessionId) {
        return paramsRepository.findBySession(sessionId);
    }
}
