package com.example.SpringBootJWTSecurityRestCRUDApplication.service;

import com.example.SpringBootJWTSecurityRestCRUDApplication.entity.StudentEntity;
import com.example.SpringBootJWTSecurityRestCRUDApplication.model.ResponseMessage;
import com.example.SpringBootJWTSecurityRestCRUDApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service //to specify class service is available as bean to spring container
public class StudentService implements UserDetailsService {

    @Autowired //to autowire the beans that inject the object created by spring container
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        StudentEntity user = studentRepository.findByUsername(username);
        if(user!=null){
            roles= Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new User(user.getUsername(),user.getPassword(),roles);
        }

        throw new UsernameNotFoundException("User not found for "+username);
    }

    public ResponseMessage createStudent(StudentEntity studentEntity){
        studentRepository.save(studentEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }
    public StudentEntity getStudentByUsername(String username){
        return studentRepository.findByUsername(username);
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
