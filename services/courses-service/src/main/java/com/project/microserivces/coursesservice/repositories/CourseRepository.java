package com.project.microserivces.coursesservice.repositories;

import com.project.microserivces.coursesservice.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

  @Query(value = "SELECT *  FROM course c where c.course_id = ?1", nativeQuery = true)
  Course getById(String id);
}
