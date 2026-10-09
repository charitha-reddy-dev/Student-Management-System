package com.example.student.repository;

import org.springframework.stereotype.Repository;
import com.example.student.entity.*;
import org.springframework.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
