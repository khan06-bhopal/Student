package com.Student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Student.entity.StudentEntity;


public interface StudentService {

	//user operations

    //create

       StudentEntity saveStudent(StudentEntity student);
    //get all user
    List<StudentEntity> getAllStudent();

    //get single user of given userId

    ResponseEntity<?> getstudent(int id);

    //TODO: delete
    //TODO: update
}

