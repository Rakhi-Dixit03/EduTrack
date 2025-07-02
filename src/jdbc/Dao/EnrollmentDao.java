package jdbc.Dao;

import jdbc.model.Enrollment;
import java.util.List;

public interface EnrollmentDao {

void enrollStudent(int studentId,int courseId,int instructorId);
List<Enrollment> getAllEnrollments();
List<Enrollment>getEnrollmentsByStudent(int studentId);
void deleteEnrollment(int enrollId);

}
