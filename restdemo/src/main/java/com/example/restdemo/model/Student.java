package com.example.restdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student1")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    private int id;

    @Indexed
    private String firstName;
    private String lastName;
}
