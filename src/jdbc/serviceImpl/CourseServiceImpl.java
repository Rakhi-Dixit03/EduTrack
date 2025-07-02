package jdbc.serviceImpl;

import jdbc.Dao.CourseDao;
import jdbc.DaoImp.CourseDaoImpl;
import jdbc.model.Course;
import jdbc.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    public CourseServiceImpl() {
        this.courseDao = new CourseDaoImpl();

    }

    @Override

    public void addCourse(Course course) {

        courseDao.addCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public Course findCourseById(int id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public void removeCourse(int id) {
        courseDao.deleteCourse(id);
    }
}
