package titan.io.studentmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import titan.io.studentmsapi.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    Result findByRoll(int roll);
}
