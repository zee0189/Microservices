package com.project.microservice.userservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppUser {

  @NotNull(message = "First Name cannot be Null")
  private String firstName;

  @NotNull(message = "Last Name cannot be Null")
  private String lastName;

  @NotNull(message = "Password cannot be Null")
  private String password;

  @NotNull(message = "Email cannot be Null")
  @Email
  private String email;
}
