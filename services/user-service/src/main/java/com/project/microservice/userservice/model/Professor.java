package com.project.microservice.userservice.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Professor {
  @Id
  private String profId;
  private String department;
  private List<String> optedCourses;
}
