package employee.management.cd.service;

import employee.management.cd.model.Employee;

import java.util.List;

public interface EmployeeService {

    //A method to register Employee
    public String registerEmployee(Employee employee);

    //A method to get all Employee ifo
    public List<Employee> getAllEmployees();

}
