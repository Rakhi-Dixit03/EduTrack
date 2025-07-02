package jdbc.DaoImp;

import jdbc.Dao.CourseDao;
import jdbc.db.DBConnection;
import jdbc.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {


    @Override
    public void addCourse(Course course) {

        String query = "INSERT INTO Course(CourseID, CourseTitle,Credits) VALUES(?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseTitle());
            ps.setInt(3, course.getCredits());

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in adding  course :" + e.getMessage());

        }


    }


    @Override
    public List<Course> getAllCourses() {

        String query = "SELECT * FROM Course";

        List<Course> Courses = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Course course = new Course();

                course.setCourseId(rs.getInt("CourseID"));
                course.setCourseTitle(rs.getString("CourseTitle"));
                course.setCredits(rs.getInt("Credits"));


                Courses.add(course);
            }

        } catch (SQLException e) {
            System.out.println("Error in getting all Courses" + e.getMessage());
        }
        return Courses;
    }

    @Override
    public Course getCourseById(int id) {
        String query = "SELECT * FROM Course WHERE CourseID = ?";
        Course course = null;

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                course = new Course();
                course.setCourseId(rs.getInt("CourseID"));
                course.setCourseTitle(rs.getString("CourseTitle"));
                course.setCredits(rs.getInt("Credits"));

            }

        } catch (SQLException e) {
            System.err.println("Error in getting CourseByID" + e.getMessage());
        }

        return course;
    }

    @Override
    public void updateCourse(Course course) {


        String query = "UPDATE Course SET CourseTitle=?,Credits = ? WHERE CourseId=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setString(1, course.getCourseTitle());
            ps.setInt(2, course.getCredits());
            ps.setInt(3, course.getCourseId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error in updating Course" + e.getMessage());

        }
    }

    @Override
    public void deleteCourse(int id) {
        String query = "DELETE FROM  Course WHERE  CourseID=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in deleting Course" + e.getMessage());

        }
        System.out.println("Deleted Course successfully!");

    }
}

