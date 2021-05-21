package com.ozeeesoftware.springaop.repository;


import com.ozeeesoftware.springaop.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
