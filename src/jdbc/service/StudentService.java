package jdbc.service;

import jdbc.model.Student;

import java.util.List;

public interface StudentService {

    void registerStudent(Student student);

    List<Student> getAllStudents();

    Student findStudentById(int id);

    void removeStudent(int id);

    void updateStudent(Student student);

}
