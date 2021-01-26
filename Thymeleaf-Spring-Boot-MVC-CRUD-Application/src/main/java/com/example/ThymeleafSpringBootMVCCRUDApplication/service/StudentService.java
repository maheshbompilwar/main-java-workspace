package com.example.ThymeleafSpringBootMVCCRUDApplication.service;

import com.example.ThymeleafSpringBootMVCCRUDApplication.model.Message;
import com.example.ThymeleafSpringBootMVCCRUDApplication.model.Student;
import com.example.ThymeleafSpringBootMVCCRUDApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Message addStudent(Student student){
         studentRepository.save(student);
        return new Message("Student added successfully", true);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public String deleteStudent(long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.deleteById(id);
            return "Student Deleted Successfully....";
        } else {
            return "Student does not exist";
        }
    }
}
