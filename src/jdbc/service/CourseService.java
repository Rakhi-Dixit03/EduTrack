package jdbc.service;

import jdbc.model.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);

    List<Course> getAllCourses();

    Course findCourseById(int id);

    void removeCourse(int id);

    void updateCourse(Course course);


}
