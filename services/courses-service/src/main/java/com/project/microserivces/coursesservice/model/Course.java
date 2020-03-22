package com.project.microserivces.coursesservice.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Course {
  @Id
  private String courseId;
  @Enumerated(EnumType.STRING)
  private Slot slot;
  private String courseName;
  private String lecturerId;
}
