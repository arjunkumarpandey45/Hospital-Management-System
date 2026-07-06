package com.arjunkumarpandey.HospitalManagementSystem.repository;

import com.arjunkumarpandey.HospitalManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
