package io.ulti.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ulti.dao.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
