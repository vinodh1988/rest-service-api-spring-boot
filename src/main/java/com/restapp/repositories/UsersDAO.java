package com.restapp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restapp.entities.Users;

public interface UsersDAO extends JpaRepository<Users,Long>{
  Users findUsersByUsername(String username);
}