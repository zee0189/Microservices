package com.project.microservice.userservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class AppUserDetails{
  @Id
  private String userId;
  private String password;
  private String firstName;
  private String lastName;
  private String email;
  private String role;

}
