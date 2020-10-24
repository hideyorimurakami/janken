package com.example.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JankenUserRepository extends JpaRepository<JankenUser, Integer> {

}
