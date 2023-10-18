package com.example.testJWT.repository;

import Entities.User;
import com.example.testJWT.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserDto, Integer> {

    Optional <UserDto> findByEmail(String email);
    Optional <UserDto> findByNAme (String nom);

}
