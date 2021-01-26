package com.example.SpringBootJWTSecurityRestCRUDApplication.controller;

import com.example.SpringBootJWTSecurityRestCRUDApplication.entity.StudentEntity;
import com.example.SpringBootJWTSecurityRestCRUDApplication.model.ResponseMessage;
import com.example.SpringBootJWTSecurityRestCRUDApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController //to make a controller as rest controller which communicate with JSON and XML for REST API
public class StudentController {

    @Autowired //to autowire the beans that inject the object created by spring container
    StudentService studentService;

    //URL- localhost:8080
    @GetMapping("/")
    public String welcome(){
        return "Welcome to spring boot...";
    }

    //URL- localhost:8080/create-student   and BODY
    @PostMapping("create-student")
    public ResponseMessage createStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createStudent(studentEntity);
    }

    //URL- localhost:8080/get-student/1
    @GetMapping("get-student/{id}")
    public StudentEntity getStudent(@PathVariable long id){
        return studentService.getStudent(id);
    }

    //URL- localhost:8080/get-students
    @GetMapping("get-students")
    public List<StudentEntity> getStudents(){
        return studentService.getStudents();
    }

    //URL- localhost:8080/update-student   and BODY
    @PutMapping("update-student")
    public ResponseMessage updateStudent(@RequestBody StudentEntity studentEntity){
        return studentService.updateStudent(studentEntity);
    }

    //URL- localhost:8080/delete-student/1
    @DeleteMapping("delete-student/{id}")
    public ResponseMessage deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }
}
