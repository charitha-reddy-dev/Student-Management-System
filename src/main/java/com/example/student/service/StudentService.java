package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentService {

@Autowired	
private  StudentRepository studentRepository;
public StudentService(StudentRepository studentRepository) {
	this.studentRepository=studentRepository;
}


// adding a student
public Student addStudent(Student student) {
	
	return studentRepository.save(student);
}


//get all the students
public List<Student>getAllStudents(){
	return studentRepository.findAll();
}


//get student by id
public Student getStudentById(int id) {
	return studentRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with ID: "+id));
}


//update student
public Student updateStudent(int id,Student student) {
	Student s=getStudentById(id);
	s.setName(student.getName());
	s.setEmail(student.getEmail());
    s.setCourse(student.getCourse());
    s.setAge(student.getAge());
    
    
    return studentRepository.save(s);
}


//delete student

public void deleteStudent(int id) {
	Student student=getStudentById(id);
	studentRepository.delete(student);
}


}
