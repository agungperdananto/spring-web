package com.github.springweb.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Login {

    @NotBlank(message = "username can't be null")
    @Size(min=3, max=20, message = "username length cannot more than 20 and less than 3 characters")
    private String username;

    @NotBlank(message = "password can't be null")
    @Size(min=6, message = "username length cannot less than 10 characters")
    private String password;
}
