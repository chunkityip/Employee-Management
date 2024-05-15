package employee.management.cd.service.impl;


import employee.management.cd.model.Employee;
import employee.management.cd.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class ServiceImplementation implements EmployeeService {

    //A method to register Employee
    //It will first check is the email or Id already exist. If yes , return message
    //If no , register as new employee
    @Override
    public String registerEmployee(Employee employee) {

    }
}
