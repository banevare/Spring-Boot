package com.example.demo.student;

import org.springframework.web.bind.annotation.*;
import java.util.List;

                                                                                                                        // all resources of the API -- Remove RestController from Student.java
@RestController                                                                                                         //
@RequestMapping("api/v1/student")                                                                                       // http://localhost:8080/api/v1/student
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
   @GetMapping                                                                                                          // HTTP Get request
    public List<Student> getStudents() {						                                                        // Returns a JSON back
        return studentRepository.findAll();
    }
    @PostMapping()                                                                                                      // HTTP Post request
    public List<Student> postStudents(@RequestParam("id") Long id, @RequestParam("name") String name,
                               @RequestParam("email")  String email) {
        return studentRepository.findAll();
    }
    
    @GetMapping("/delete")                                                                                              // http://localhost:8080/api/v1/student/delete?id=
    public String deleteById(@RequestParam("id") Long id, @RequestParam("name") String name,
                             @RequestParam("email")  String email) {
        if (studentRepository.existsById(id)) studentRepository.deleteById(id);
        else throw new IllegalStateException("student with id" + id + " does not exists");
        return "<table>  <tr> <th> name <th> email <tr> <td> " + name + " <td> " + email + "</table>" +
                "<p> you joined FRP </p>";
    }
}