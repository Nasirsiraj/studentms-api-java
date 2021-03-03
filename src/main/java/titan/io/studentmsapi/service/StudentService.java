package titan.io.studentmsapi.service;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import titan.io.studentmsapi.model.Student;
import titan.io.studentmsapi.repository.StudentRepository;

import java.util.List;

@Slf4j
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // get all student
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    // get student by id
    public Student getStudentById(@NotNull int id){
        return studentRepository.findById(id).orElse(null);
    }
    // get student by roll
    public Student getStudentByRoll(@NotNull int roll){
        return studentRepository.findByRoll(roll);
    }
    // post one student
    public Student postOneStudent(@NotNull Student student){
        Student existingStudent = studentRepository.findByRoll(student.getRoll());
        if(existingStudent != null){
            // already roll exist
            return null;
        }else {
            return studentRepository.save(student);
        }
    }
    // post all student
    public List<Student> postAllStudent(@NotNull List<Student> studentList){
        return studentRepository.saveAll(studentList);
    }
    // delete student by id
    public String deleteStudentById(@NotNull int id){
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if(existingStudent == null){
            return "no student found, id: " + id;
        }else{
            studentRepository.deleteById(id);
            return "student deleted, id: " + id;
        }
    }
    // delete student by student obj
    public String deleteStudentByObj(@NotNull Student student){
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        if(existingStudent == null){
            return "no student found, id: " + student.getId();
        }else{
            studentRepository.delete(student);
            return "student deleted, id: " + student.getId();
        }
    }
    // update student by student obj
    public Student updateStudent(@NotNull Student student){
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        if(existingStudent == null){
            return null;
        }else {
            existingStudent.setName(student.getName());
            existingStudent.setRoll(student.getRoll());
            existingStudent.setReg(student.getReg());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setDepartment(student.getDepartment());
            existingStudent.setSemester(student.getSemester());

            return studentRepository.save(existingStudent);
        }
    }
}
