package com.github.springweb.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Login {

    @NotEmpty(message = "username can't be null")
    @Size(min=3, max=20, message = "username length cannot more than 20 and less than 3 characters")
    private String username;

    @NotEmpty(message = "password can't be null")
    @Size(min=8, message = "password length must not less than 8")
    private String password;
}
