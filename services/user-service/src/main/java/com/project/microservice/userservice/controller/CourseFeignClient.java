package com.project.microservice.userservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("course-ws")
public interface CourseFeignClient {

  @GetMapping("/course/get")
  public ResponseEntity<?> getAllCourse();

}
