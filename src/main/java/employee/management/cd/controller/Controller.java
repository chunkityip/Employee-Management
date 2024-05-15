package employee.management.cd.controller;


import employee.management.cd.dao.EmployeeRepository;
import employee.management.cd.model.Employee;
import employee.management.cd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class Controller {

    @Autowired
    public EmployeeRepository repository;

    @Autowired
    public EmployeeService service;

    @PostMapping("/register")
    public String register(@RequestBody Employee employee) {
        return service
    }
}
