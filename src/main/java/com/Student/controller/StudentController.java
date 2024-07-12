package com.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.entity.StudentEntity;
import com.Student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public StudentEntity  createStudent(@RequestBody StudentEntity student) { 
		
		return studentService.saveStudent(student);
	}
	
	@GetMapping
	public List<StudentEntity> fetchAllStudent(){ 
		
		return studentService.getAllStudent();
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<?> fetchStudentById(@PathVariable int id){ 
		return studentService.getstudent(id);
		
	}

}
