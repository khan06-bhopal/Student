package com.Student.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Student.entity.School;
import com.Student.entity.StudentEntity;
import com.Student.entity.StudentResponse;
import com.Student.repository.StudentRepository;
import com.Student.service.StudentService;
import org.springframework.http.ResponseEntity;


@Service
public class studentImpl implements StudentService {



	   @Autowired
	  private StudentRepository studentRepository;
	   
	   @Autowired
	   private RestTemplate restTemplate;
	   
	   
	@Override
	public StudentEntity saveStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		// TODO Auto-generated method stub
		return  studentRepository.findAll();
	}

	@Override
	public ResponseEntity<?> getstudent(int id) {
		// TODO Auto-generated method stub
		Optional<StudentEntity> student =  studentRepository.findById(id);
        if(student.isPresent()){
            School school = restTemplate.getForObject("http://localhost:8081/schools/" + student.get().getSchoolId(), School.class);
            StudentResponse studentResponse = new StudentResponse(
                    student.get().getId(),
                    student.get().getName(),
                    student.get().getAge(),
                    student.get().getGender(),
                    school
            );
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }	}

}
