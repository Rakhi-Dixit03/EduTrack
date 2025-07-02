package jdbc.service;

import jdbc.model.Instructor;

import java.util.List;

public interface InstructorService {

    void addInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Instructor findInstructorById(int id);

    void removeInstructor(int id);

    void updateInstructor(Instructor instructor);

}
