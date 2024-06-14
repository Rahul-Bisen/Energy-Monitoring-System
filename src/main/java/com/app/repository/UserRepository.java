package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Optionals;

import com.app.entity.Consumer;
import com.app.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByEmailAndPassword(String email, String password);

	Optional<Users> findByEmail(String email);

}
