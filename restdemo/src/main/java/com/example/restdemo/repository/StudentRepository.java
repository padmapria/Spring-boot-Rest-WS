package com.example.restdemo.repository;

import com.example.restdemo.model.Student;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {



}
