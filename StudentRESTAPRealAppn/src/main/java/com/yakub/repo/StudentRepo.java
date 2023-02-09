package com.yakub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yakub.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
