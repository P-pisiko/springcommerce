package dev.commerse.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class NewCustomerRequestDTO {

    @NotNull(message = "Username cannot be empty!")
    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 3 ,max = 32, message = "Username cannot be longer then 32")
    private String username;
    @NotNull(message = "Password cannot be empty!")
    @NotBlank(message = "Password cannot be empty!")
    private String password;
    @NotNull(message = "Password cannot be empty!")
    @NotBlank(message = "Password cannot be empty!")
    private String confirm ;
}
