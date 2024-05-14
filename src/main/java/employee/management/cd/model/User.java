package employee.management.cd.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class User {

    private String username;
    private String[] password;
}
