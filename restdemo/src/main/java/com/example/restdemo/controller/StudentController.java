package com.example.restdemo.controller;

import com.example.restdemo.model.Student;
import com.example.restdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping(value= "/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> get(@PathVariable int id){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");

        Student student= studentService.get(id);
        if(student==null)
            return ResponseEntity.notFound().headers(headers).build();
        return ResponseEntity.ok().headers(headers).body(student);
    }

    @GetMapping(value = "/findall")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping(value = "/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student){
       return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll(){
        studentService.deleteAll();
    }

}
