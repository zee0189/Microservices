package com.project.microserivces.coursesservice.controller;

import com.google.common.base.Strings;
import com.project.microserivces.coursesservice.model.Course;
import com.project.microserivces.coursesservice.repositories.CourseRepository;
import com.project.microserivces.coursesservice.service.CourseService;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/course")
public class CourseController {

  @Autowired
  private CourseRepository courseRepository;
  @Autowired
  private CourseService courseService;

  @PostMapping(value = "/create")
  public ResponseEntity<?> addCourse(@RequestBody Course course) {

    course.setCourseId(UUID.randomUUID().toString());
    courseRepository.save(course);
    return ResponseEntity.status(HttpStatus.CREATED).body(course);
  }

  @PutMapping("/update")
  public ResponseEntity<?> updateCourse(@RequestBody Course course) {
    if (Strings.isNullOrEmpty(course.getCourseId())) {
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
          .body("Course Id is required to update course");
    }

    Optional<Course> courseById = courseRepository.findById(course.getCourseId());
    if (!courseById.isPresent()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT)
          .body(String.format("Course id : %s doesn't is invalid", course.getCourseId()));
    }
    Course updatedCourse = courseService.updateCourse(course, courseById.get());
    return ResponseEntity.status(HttpStatus.OK).body(course);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteCourse(@PathVariable("id") String id) {
    Optional<Course> courseById = courseRepository.findById(id);
    if (!courseById.isPresent()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT)
          .body(String.format("Course id : %s doesn't exists", id));
    }
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getAllCourse() {
    return ResponseEntity.ok(StreamSupport.stream(courseRepository.findAll().spliterator(), false).collect(
        Collectors.toList()));
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<?> getCourse(@PathVariable("id") String id) {
    Optional<Course> courseById = courseRepository.findById(id);
    if (!courseById.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(String.format("No course with id: %s is found", id));
    }
    return ResponseEntity.ok(courseById.get());
  }

}
