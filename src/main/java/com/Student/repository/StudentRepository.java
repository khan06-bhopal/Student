package com.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Student.entity.StudentEntity;

@Repository
public interface StudentRepository  extends JpaRepository<StudentEntity, Integer>{
	
	

}
