package titan.io.studentmsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentmsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentmsApiApplication.class, args);
        System.out.println("Welcome to Student Management System API Java version.");
    }
}
