package employee.management.cd.service.impl;


import employee.management.cd.dao.EmployeeRepository;
import employee.management.cd.model.Employee;
import employee.management.cd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    //A method to register Employee
    //It will first check is the email or Id already exist. If yes , return message
    //If no , register as new employee
    @Override
    public String registerEmployee(Employee employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            return "Employee with this mail: " + employee.getEmail() + "already exit";
        } else if (repository.existsById(employee.getId())) {
            return "Employee with this id: " + employee.getId() + "already exit";
        } else {
            repository.save(employee);
            return "Hi " + employee.getFirstName() + ". Your registration process is completed";
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return
    }
}
