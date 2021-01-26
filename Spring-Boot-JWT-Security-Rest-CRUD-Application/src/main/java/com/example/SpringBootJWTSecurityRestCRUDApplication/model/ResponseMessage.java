package com.example.SpringBootJWTSecurityRestCRUDApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data  //Lombok annotation for getters and setters
@AllArgsConstructor //Lombok annotation for All argument constructor
@NoArgsConstructor //Lombok annotation for No argument constructor
@ToString //Lombok annotation for toString method
public class ResponseMessage {
    private String message;
    private boolean flag;
}
