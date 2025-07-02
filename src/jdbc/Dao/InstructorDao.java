package jdbc.Dao;

import jdbc.model.Instructor;
import java.util.List;

public interface InstructorDao {

    void addInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorByID(int id);
    void updateInstructor(Instructor instructor);
    void deleteInstructor(int id);

}
