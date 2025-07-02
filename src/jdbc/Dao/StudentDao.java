package jdbc.Dao;
import jdbc.model.Student;
import java.util.List;

public interface StudentDao {

    void addStudent(Student student);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    Student getStudentByID(int id);
    void deleteStudent(int id);


}
