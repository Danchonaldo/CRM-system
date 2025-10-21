package crmsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crmsystem.entity.Operators;

import crmsystem.repository.OperatorRepository;

import java.util.List;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    public List<Operators> getAllOperators() {
        return operatorRepository.findAll();
    }

}