package com.project.microservice.userservice.repository;

import com.google.common.collect.ImmutableList;
import com.project.microservice.userservice.model.Professor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface ProfessorRepository extends CrudRepository<Professor, String> {
//
//  @Query(value = "update professor p set p.opted_courses = array_append(?1) where p.prof_id = ?2", nativeQuery = true)
//  int updateProfessor(String professorId, String courseId);
//}

public class ProfessorRepository {

  private List<Professor> PROFESSOR_LIST =  ImmutableList.of(Professor.builder().profId("PF124").department("Science").build(),
      Professor.builder().profId("PF125").department("Science").build(),
      Professor.builder().profId("PF126").department("IT").build(),
      Professor.builder().profId("PF127").department("IT").build());

  public List<Professor> getProfessorList() {
    return PROFESSOR_LIST;
  }

  public Professor getById(String id){
     return PROFESSOR_LIST.stream().filter(professor -> professor.getProfId().equals(id)).findFirst().get();
  }

  public Professor updateProfessor(String id ,String courseId){
    Professor profById = getById(id);
    profById.getOptedCourses().add(courseId);
    return profById;
  }
}