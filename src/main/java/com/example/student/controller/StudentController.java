package com.example.student.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
  private final StudentService studentService;
  
  
  public StudentController(StudentService studentService) {
	  this.studentService=studentService;
  }
  
  @PostMapping
  public Student addStudent(@RequestBody Student student) {
	  return studentService.addStudent(student);
  }
  
  
  @GetMapping
  public List<Student> getAllStudents(){
	  return studentService.getAllStudents();
  }


  @GetMapping("/{id}")
  public Student getStudentById(@PathVariable int id) {
	  return studentService.getStudentById(id);
  }
  
  
  @PutMapping("/{id}")
  public Student updateStudent(@PathVariable int id,@RequestBody Student student) {
	  return studentService.updateStudent(id, student);
  }
  
  @DeleteMapping("/{id}")
  public void deleteStudent(@PathVariable int id) {
	  studentService.deleteStudent(id);
  }
  
}
