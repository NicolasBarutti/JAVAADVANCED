package br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.datasource.repositories;

import br.com.fiap._tds.javaAdv.app01.ExemploSpringRest.domainmodel.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeMockRepository {

    private final List<Employee> dataset = new ArrayList<>();

    public EmployeeMockRepository() {
        this.dataset.add(new Employee(1L,"Nicolas","CEO","ADM"));
        this.dataset.add(new Employee(2L,"Lucas","Operario","Producao"));
        this.dataset.add(new Employee(3L,"Kleber","CEO","ADM"));
        this.dataset.add(new Employee(4L,"Tiago","Fundador","ADM"));
        this.dataset.add(new Employee(5L,"Kim","CEO","ADM"));

    }

    public List<Employee> getAll(){
        return this.dataset;
    }
}
