package com.example.Student.management.controller;

import com.example.Student.management.model.Student;
import com.example.Student.management.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
@CrossOrigin("*")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students= studentService.getAllStudents();
                return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("id") Long id){
        Student students= studentService.findStudentById(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent= studentService.addStudent(student);
        return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> putStudent(@RequestBody Student student){
        Student updateStudent= studentService.updateStudent(student);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
//        studentService.deleteStudentById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @DeleteMapping("/delete/{id}")
//    public void deleteStudentById(@PathVariable("id") Long id){
//        studentService.deleteStudentById(id);
//        }

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
    studentService.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.OK);
}
}
