package com.stepit.lecture.genericshop.user.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stepit.lecture.genericshop.user.entity.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
