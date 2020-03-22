package com.project.microservice.userservice.controller;

import com.project.microservice.userservice.model.Professor;
import com.project.microservice.userservice.repository.ProfessorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prof")
public class ProfessorController {

  @Autowired
  private CourseFeignClient courseFeignClient;

  @GetMapping("/get")
  public ResponseEntity<?> getCourses(){
    return ResponseEntity.status(HttpStatus.OK).body(courseFeignClient.getAllCourse().getBody());
  }

//  @Autowired
//  private ProfessorRepository professorRepository;
//
//  @PostMapping("/create")
//  public ResponseEntity<?> createProf(@RequestBody Professor professor){
//     professorRepository.save(professor);
//     return ResponseEntity.status(HttpStatus.CREATED).body(professor);
//  }
//
//  @GetMapping("/get/{id}")
//  public ResponseEntity<?> getProfById(@PathVariable("id") String profId){
//    Optional<Professor> byId = professorRepository.findById(profId);
//    return ResponseEntity.status(HttpStatus.OK).body(byId.get());
//  }

}
