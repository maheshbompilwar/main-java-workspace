package com.example.SpringBootJWTSecurityRestCRUDApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data  //Lombok annotation for getters and setters
@AllArgsConstructor //Lombok annotation for All argument constructor
@NoArgsConstructor //Lombok annotation for No argument constructor
@ToString //Lombok annotation for toString method
@Entity //to specify the class is entity and mapped with database table
@Table(name = "STUDENT") //specify the name of the database table to be used for mapping.
public class StudentEntity {
    @Id //used to define the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //used to auto generate primary key
    @Column(name = "ID") //to specify database table's column name
    private long id;

    @Column(name = "NAME") //to specify database table's column name
    private String name;

    @Column(name = "ROLL_NO") //to specify database table's column name
    private int rollNo;

    @Column(name = "EMAIL") //to specify database table's column name
    private String email;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private String role;
}
