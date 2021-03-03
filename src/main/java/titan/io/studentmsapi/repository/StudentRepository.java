package titan.io.studentmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import titan.io.studentmsapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByRoll(int roll);
}
