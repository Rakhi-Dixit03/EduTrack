package jdbc.serviceImpl;

import jdbc.Dao.StudentDao;
import jdbc.DaoImp.StudentDaoImpl;
import jdbc.model.Student;
import jdbc.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl() {
        this.studentDao = new StudentDaoImpl();

    }

    @Override
    public void registerStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student findStudentById(int id) {
        return studentDao.getStudentByID(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void removeStudent(int id) {
        studentDao.deleteStudent(id);
    }
}
