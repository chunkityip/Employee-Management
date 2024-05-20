package employee.management.cd.service;

import employee.management.cd.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    //A method to register Employee
    public String registerEmployee(Employee employee);

    //A method to get Employee email
    //Since we are just doing linear searching , List is easier
    public List<Employee> getByEmail(String email);

    //A method to get all Employee ifo
    //Since we are just doing linear searching , List is easier
    public List<Employee> getAllEmployees();

    //A method to delete employee by their id
    //Since we are just doing linear searching , List is easier
    public List<Employee> deleteById(int id);

    //A method to update employee info
    //Since we are just doing linear searching , List is easier
    public String updateEmployee(Employee employee);

    //A method to validate user
    //Since we are just doing linear searching , List is easier
    public Employee validateUser(String user , String password);

    //A method to check Employee info base on their first name
    //Since we are just doing linear searching , List is easier
    public List<Employee> getByFirstName(String firstname);

    //A method to check Employee experience
    //Since we are just doing linear searching , List is easier
    public List<Employee> getEmployeeByExperience(int experience);

    //A method to get all Employee info by page
    //Since we like to display Employee base by page , page as key will be better
    public Map<String , Object> getAlLEmployeeInPage(int pageNo , int pageSize , String sortBy);



}
