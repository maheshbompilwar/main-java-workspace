package com.example.SpringBootRestCRUDApplication.repository;

import com.example.SpringBootRestCRUDApplication.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //to specify the interface repository is available as bean to spring container
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
