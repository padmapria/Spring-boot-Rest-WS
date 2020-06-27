package com.example.restdemo.service;

import com.example.restdemo.model.Student;
import com.example.restdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student get(int id){
        Optional<Student> student =  studentRepository.findById(id);
        if(student.isPresent())
            return student.get();
        else
            return null;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student save(Student student){
        studentRepository.save(student);
        return student;
    }

    public Student update(int id, Student student) {
        Optional<Student> stud = studentRepository.findById(id);
        if (stud.isPresent()) {
            studentRepository.save(student);
        }
        return student;
    }

    public void deleteAll(){
        studentRepository.deleteAll();
    }

    public void delete(int id) {
        Student stud = this.get(id);
        if(stud!=null)
            studentRepository.delete(stud);
    }
}
