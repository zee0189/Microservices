package com.project.microservice.userservice.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Students {

  private String userId;
  private List<String> booksBorrowed;
  private List<String> optedCourses;

}
