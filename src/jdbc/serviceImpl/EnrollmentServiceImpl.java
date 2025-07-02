package jdbc.serviceImpl;

import jdbc.Dao.EnrollmentDao;
import jdbc.DaoImp.EnrollmentDaoImpl;
import jdbc.model.Enrollment;
import jdbc.service.EnrollmentService;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {


    private final EnrollmentDao enrollDao;


    public EnrollmentServiceImpl() {
        enrollDao = new EnrollmentDaoImpl();

    }

    @Override
    public void makeEnrollment(int studentId, int courseId, int instructorId) {
        enrollDao.enrollStudent(studentId, courseId, instructorId);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollDao.getAllEnrollments();
    }

    @Override
    public List<Enrollment> findEnrollmentsByStudent(int studentId) {
        return enrollDao.getEnrollmentsByStudent(studentId);
    }

    @Override
    public void removeEnrollment(int enrollId) {
        enrollDao.deleteEnrollment(enrollId);
    }
}
