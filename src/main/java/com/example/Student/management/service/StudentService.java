package com.example.Student.management.service;

import com.example.Student.management.exception.userNotFoundException;
import com.example.Student.management.model.Student;
import com.example.Student.management.repo.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
     @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(Student student){
         student.setStudentCode(UUID.randomUUID().toString());
         return studentRepository.save(student);
    }
    public List<Student> getAllStudents(){
         return studentRepository.findAll();
    }
    public Student updateStudent(Student student){
         return studentRepository.save(student);
    }
    public void deleteStudentById(Long id){
         studentRepository.deleteById(id);
    }
    public Student findStudentById(Long id){
         return studentRepository.findStudentById(id).orElseThrow(()-> new userNotFoundException("user by "+id+" was not found"));
    }

    @Transactional
    public void deleteStudent(Long id){
        studentRepository.deleteStudentById(id);
    }
}
