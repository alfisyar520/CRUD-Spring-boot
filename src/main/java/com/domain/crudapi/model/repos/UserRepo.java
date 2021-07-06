package com.domain.crudapi.model.repos;

import com.domain.crudapi.model.entities.Product;
import com.domain.crudapi.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
//    List<User> findByNameContains(String firstName);
}
