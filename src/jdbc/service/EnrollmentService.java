package jdbc.service;

import jdbc.model.Enrollment;

import java.util.List;

public interface EnrollmentService {

    void makeEnrollment(int studentId, int courseId, int instructorId);

    List<Enrollment> getAllEnrollments();

    List<Enrollment> findEnrollmentsByStudent(int studentId);

    void removeEnrollment(int enrollId);


}
