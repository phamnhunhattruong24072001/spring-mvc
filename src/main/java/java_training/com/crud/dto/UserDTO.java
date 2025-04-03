package java_training.com.crud.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
