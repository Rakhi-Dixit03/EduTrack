package jdbc.serviceImpl;

import jdbc.Dao.InstructorDao;
import jdbc.DaoImp.InstructorDaoImpl;
import jdbc.model.Instructor;
import jdbc.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {

    private final InstructorDao instructorDao;

    public InstructorServiceImpl() {

        this.instructorDao = new InstructorDaoImpl();


    }

    @Override
    public void addInstructor(Instructor instructor) {

        instructorDao.addInstructor(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorDao.getAllInstructors();
    }

    @Override
    public Instructor findInstructorById(int id) {
        return instructorDao.getInstructorByID(id);
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        instructorDao.updateInstructor(instructor);
    }

    @Override
    public void removeInstructor(int id) {
        instructorDao.deleteInstructor(id);
    }
}
