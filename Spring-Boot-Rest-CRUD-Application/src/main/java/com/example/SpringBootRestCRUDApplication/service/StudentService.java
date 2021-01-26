package com.example.SpringBootRestCRUDApplication.service;

import com.example.SpringBootRestCRUDApplication.entity.StudentEntity;
import com.example.SpringBootRestCRUDApplication.model.ResponseMessage;
import com.example.SpringBootRestCRUDApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //to specify class service is available as bean to spring container
public class StudentService {

    @Autowired //to autowire the beans that inject the object created by spring container
    StudentRepository studentRepository;

    public ResponseMessage createStudent(StudentEntity studentEntity){
        studentRepository.save(studentEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    public StudentEntity getStudent(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentEntity> getStudents(){
        return studentRepository.findAll();
    }

    public ResponseMessage updateStudent(StudentEntity studentEntity){
//        long id = studentEntity.getId();
//        StudentEntity student = studentRepository.findById(id).orElse(null);
//        if(student!=null){
//            studentRepository.save(studentEntity);
//        }else {
//
//        }

        if(studentRepository.findById(studentEntity.getId())!=null){
            studentRepository.save(studentEntity);
            return new ResponseMessage("Record Updated Successfully...", true);
        }else {
            return new ResponseMessage("Record did not update...", false);
        }
    }

    public ResponseMessage deleteStudent(long id){
        if(studentRepository.findById(id)!=null){
            studentRepository.deleteById(id);
            return new ResponseMessage("Record Deleted Successfully...",true);
        }else {
            return new ResponseMessage("Record did not delete...",false);
        }
    }
}
