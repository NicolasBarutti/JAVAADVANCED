package br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.controllers;

import br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.datasource.repositories.EmployeeMockRepository;
import br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.domainmodel.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private final EmployeeMockRepository employeeMockRepository;

    public EmployeeController(EmployeeMockRepository employeeMockRepository) {
        this.employeeMockRepository = employeeMockRepository;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> listAll(){
        return new ResponseEntity<>(this.employeeMockRepository.getAll(),HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
