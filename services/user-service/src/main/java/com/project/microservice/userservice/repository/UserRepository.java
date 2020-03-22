package com.project.microservice.userservice.repository;

import com.project.microservice.userservice.model.AppUserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUserDetails, Long> {

}
