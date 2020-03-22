package com.project.microserivces.coursesservice.service;

import com.google.common.base.Strings;
import com.project.microserivces.coursesservice.model.Course;
import com.project.microserivces.coursesservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  public Course updateCourse(Course course, Course existingCourse){
    Course updatedCourse = Course.builder()
        .courseName(Strings.isNullOrEmpty(course.getCourseName()) ? course.getCourseName()
            : existingCourse.getCourseName())
        .lecturerId(updateCourseIdForProfessor(course.getCourseId(), existingCourse.getCourseId()))
        .slot(course.getSlot() != null ? course.getSlot() : existingCourse.getSlot()).build();
    courseRepository.save(updatedCourse);
    return updatedCourse;
  }

  private String updateCourseIdForProfessor(String id, String existingId){
    // todo: set up to update professor entity
    if(id.equals(existingId)){
      return existingId;
    }
    return id;
  }
}
