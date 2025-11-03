package crmsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import crmsystem.entity.Operators;
import crmsystem.service.OperatorService;

import java.util.List;

@RestController
@RequestMapping("/api/operators")
public class OperatorRestController {

    @Autowired
    private OperatorService operatorService;

    @GetMapping
    public ResponseEntity<List<Operators>> getAllOperators() {
        List<Operators> operators = operatorService.getAllOperators();
        return new ResponseEntity<>(operators, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Operators> addOperator(@RequestBody Operators operator) {
        Operators newOperator = operatorService.addOperator(operator);
        return new ResponseEntity<>(newOperator, HttpStatus.CREATED);
    }
}