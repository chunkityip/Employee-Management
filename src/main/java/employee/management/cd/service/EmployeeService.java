package employee.management.cd.service;

import employee.management.cd.model.Employee;

import java.util.List;

public interface EmployeeService {

    //A method to register Employee
    public String registerEmployee(Employee employee);

    //A method to get Employee email
    public List<Employee> getByEmail(String email);

    //A method to get all Employee ifo
    public List<Employee> getAllEmployees();

    //A method to delete employee by their id
    public List<Employee> deleteById(int id);

    //A method to update employee info
    public String updateEmployee(Employee employee);

    //A method to validate user
    public Employee validateUser(String user , String password);

}
