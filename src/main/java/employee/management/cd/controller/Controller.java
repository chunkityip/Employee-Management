package employee.management.cd.controller;


import employee.management.cd.dao.EmployeeRepository;
import employee.management.cd.model.Employee;
import employee.management.cd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {

    @Autowired
    public EmployeeRepository repository;

    @Autowired
    public EmployeeService service;

    //An Api endpoint to handle register request
    @PostMapping("/register")
    public String register(@RequestBody Employee employee) {
        return service.registerEmployee(employee);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> findAllEmployees()
}
