package employee.management.cd.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Document
public class Employee  {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String[] password;
    private LocalDate dateOfBirth;
    private long mobile;
    private String email;
    private int experience;
    private String domain;
}
