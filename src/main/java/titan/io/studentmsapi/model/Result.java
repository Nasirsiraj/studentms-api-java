package titan.io.studentmsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "result")
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roll;
    private int bangla;
    private int english;
    private int math;
    private int computer;
    private int physics;
    private int chemistry;
    private int biology;
}
