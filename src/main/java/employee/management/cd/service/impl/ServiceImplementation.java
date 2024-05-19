package employee.management.cd.service.impl;


import employee.management.cd.dao.EmployeeRepository;
import employee.management.cd.model.Employee;
import employee.management.cd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    //A method to get Employee Email
    //If we found the email , return it
    //else , return null
    @Override
    public List<Employee> getByEmail(String email) {
        if (repository.existsByEmail(email)) {
            return repository.getByEmail(email);
        } else {
            return null;
        }
    }

    //A method to get all the employee info
    @Override
    public List<Employee> getAllEmployees() {
        //Creates a Sort object that specifies sorting in ascending order
        // based on the "email" property of the entities.

        /*
        Sort.by:  This is a static factory method used to create a Sort object.
        It allows you to specify the sorting criteria for your query results

        Sort.Direction.ASC: This specifies the direction of the sorting, in this case, ascending order.
        ASC stands for ascending, meaning that the results will be sorted from smallest to
        largest or from A to Z (for alphabetical sorting)
         */
        return repository.findAll(Sort.by(Sort.Direction.ASC, "email"));
    }

    //A method to delete employee by their id
    @Override
    public List<Employee> deleteById(int id) {
        repository.deleteById(id);
        //Since I want to display all employee info after deleteById()
        return repository.findAll();
    }

    //A method to update Employee info
    //If existById() is true , return a massage as updated success
    //else , return message as not fund
    @Override
    public String updateEmployee(Employee employee) {
        if (repository.existsById(employee.getId())) {
            repository.save(employee);
            return "Hi" + employee.getFirstName() + "Your profile is updated";
        } else {
            return "Employee details not found!";
        }
    }

    //A method to validate user by their username which is email and password
    @Override
    public Employee validateUser(String username, String password) {
        Employee employee = repository.findByEmail(username);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        } else {
            return null;
        }
    }


}
