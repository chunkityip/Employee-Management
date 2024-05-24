package employee.management.cd.controller;


import employee.management.cd.dao.EmployeeRepository;
import employee.management.cd.model.Employee;
import employee.management.cd.model.User;
import employee.management.cd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class Controller {

    @Autowired
    public EmployeeRepository repository;

    @Autowired
    public EmployeeService service;

    //An Api endpoint to handle register request
    //@RequestBody allow you to get complex data (such as JSON or XML) from the client in the body of a
    //POST or PUT request.
    @PostMapping("/register")
    public String registerEmployee(@RequestBody Employee employee) {
        return service.registerEmployee(employee);
    }

    //An Api to login as user
    @PostMapping("/login")
    public Employee employeeLogin(@RequestBody User user) {
        return service.validateUser(user.getUsername() , user.getPassword());
    }

    //An Api to find Employee base on Email
    //@PathVariable allows you to access dynamic values from the URL and use them in your code
    //It is useful when you want to capture values from the URL and use them in your Spring MVC controller methods
    @GetMapping("findEmployeeByEmail/{email}")
    public List<Employee> findUser(@PathVariable String email) {
        return service.getByEmail(email);
    }

    //An Api to get all Employee info
    @GetMapping("/getAllEmployees")
    public List<Employee> findAllEmployees() {
        return service.getAllEmployees();
    }

    //An Api to cancel registration
    @DeleteMapping("/delete/{id}")
    public List<Employee> cancelRegistration(@PathVariable int id) {
        return service.deleteById(id);
    }


    //An Api to update employee info
    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }


    //An Api to get Employee info base on their first name
    //@RequestParam allow you to access query parameters when the
    //parameters are optional or when dealing with a large number of parameters
    @GetMapping("/findByFirstName")
    public List<Employee> findEmployeeByFirstName(@RequestParam(name = "firstname")String firstname) {
        return service.getByFirstName(firstname);
    }

    //An Api to get Employee info base on their experience
    @GetMapping("/getEmployeeByExperience")
    public List<Employee> getEmployeeByExperience(@RequestParam(name = "experience") int experience) {
        return service.getEmployeeByExperience(experience);
    }


    //An Api endpoint to request all Employee info
    @GetMapping("/getAllEmployeesInPage")
    public Map<String , Object> getAlLEmployeeInPage(@RequestParam(name = "pageNo" , defaultValue = "0") int pageNo ,
                                                     @RequestParam(name = "pageSize" , defaultValue = "2") int pageSize,
                                                     @RequestParam(name = "sortBy" , defaultValue = "id") String sortBy) {
        return service.getAlLEmployeeInPage(pageNo , pageSize , sortBy);
    }

}
