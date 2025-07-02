package jdbc.Dao;

import jdbc.model.Course;
import java.util.List;

public interface CourseDao {

void addCourse(Course course);
List<Course> getAllCourses();
Course getCourseById(int id);
void deleteCourse(int id);
void updateCourse(Course course);


}
