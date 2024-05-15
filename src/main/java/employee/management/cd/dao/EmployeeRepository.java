package employee.management.cd.dao;

import employee.management.cd.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//MongoRepository provides all the necessary methods which help to create
// a CRUD application and it also supports the custom derived query methods

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

        //return true if the email already in the database
        boolean existsByEmail(String email);

        //A method to look for Employee by their first name
        List<Employee> findByFirstName(String firstname);


        //A method to look for Employee work experience
        List<Employee> findByExperience(int experience);

        //A method to look for Employee e-mail
        Employee findByEmail(String username);

        //A method to return Employee email
        List<Employee> getByEmail(String email);


}
