package titan.io.studentmsapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import titan.io.studentmsapi.repository.StudentRepository;

@Slf4j
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
}
