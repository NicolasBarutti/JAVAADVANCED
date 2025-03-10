package br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.controllers;

import br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.datasource.repositories.EmployeeMockRepository;
import br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.domainmodel.Employee;
import br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService service;



    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> listAll(){

        return new ResponseEntity<>(this.service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id){
        System.out.println("http://localhost:8080/api/" + id);
        return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeEmployeeByid(@PathVariable Long id){
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public  ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employeeCreated = this.service.save(employee);
        return new ResponseEntity<>(employeeCreated, HttpStatus.CREATED);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
