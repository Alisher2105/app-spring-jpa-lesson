package org.example.appspringjpalesson.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.example.appspringjpalesson.model.Student;
import org.example.appspringjpalesson.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    // Studentlar ro`yahtini olish
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    //Student Qo`shish
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student qo`shildi";
    }

    //Studentni id si bo`yicha olish
    @RequestMapping(value = "/student/{id}",method =RequestMethod.GET )
    public Student getStudent(@PathVariable Integer id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){  // isPresent degani qutini ishida student bo`lmasa degani
            Student student = optionalStudent.get();
            return student;
        }
        return new Student();
    }

    // Studentni id si bo`yicha o`chirish
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Student o`chirildi";
    }

    // Update Student By Id
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String editeStudent(@PathVariable Integer id,@RequestBody Student student){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student editingStudent = optionalStudent.get();
            editingStudent.setFirstName(student.getFirstName());
            editingStudent.setLastName(student.getLastName());
            editingStudent.setPhoneNumber(student.getPhoneNumber());
            studentRepository.save(editingStudent);
            return "Student Edited";
        }
        return "Student not found";
    }
}
