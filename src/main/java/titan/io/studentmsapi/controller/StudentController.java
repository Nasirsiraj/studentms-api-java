package titan.io.studentmsapi.controller;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import titan.io.studentmsapi.model.Student;
import titan.io.studentmsapi.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // get all student
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    // get student by id
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable @NotNull int id){
        return studentService.getStudentById(id);
    }
    // get student by roll
    @GetMapping("/studentByRoll/{roll}")
    public Student getStudentByRoll(@PathVariable @NotNull int roll){
        return studentService.getStudentByRoll(roll);
    }
    // post one student
    @PostMapping("/student")
    public Student postOneStudent(@RequestBody @NotNull Student student){
        return studentService.postOneStudent(student);
    }
    // post all student
    @PostMapping("/students")
    public List<Student> postAllStudent(@RequestBody @NotNull List<Student> studentList){
        return studentService.postAllStudent(studentList);
    }
    // delete student by id
    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable @NotNull int id){
        return studentService.deleteStudentById(id);
    }
    // delete student by student obj
    @DeleteMapping("/student")
    public String deleteStudentByObj(@RequestBody @NotNull Student student){
        return studentService.deleteStudentByObj(student);
    }
    // update student obj
    @PutMapping("/student")
    public Student updateStudent(@RequestBody @NotNull Student student){
        return studentService.updateStudent(student);
    }
}
