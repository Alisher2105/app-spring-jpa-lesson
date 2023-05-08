package org.example.appspringjpalesson.controller;

import org.example.appspringjpalesson.model.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getStudents(){
        return null;
    }
}
