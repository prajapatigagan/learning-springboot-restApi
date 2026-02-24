package com.example.learningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 5,max = 30, message = "name should be length 3 to 30 cherecter")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
