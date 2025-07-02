package jdbc.DaoImp;

import jdbc.Dao.EnrollmentDao;
import jdbc.db.DBConnection;
import jdbc.model.Enrollment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDaoImpl implements EnrollmentDao {


    @Override
    public void enrollStudent(int studentId, int courseId, int instructorId) {

        String query = "INSERT INTO Enrollment(StudentID,CourseID,InstructorID) VALUES(?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setInt(3, instructorId);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in Enrollment process :" + e.getMessage());

        }

    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        String query = "SELECT * FROM Enrollment";
        List<Enrollment> Enrollments = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Enrollment enroll = new Enrollment();

                enroll.setEnrollmentId(rs.getInt("EnrollmentId"));
                enroll.setStudentId(rs.getInt("StudentId"));
                enroll.setCourseId(rs.getInt("CourseID"));
                enroll.setInstructorId(rs.getInt("InstructorID"));


                Enrollments.add(enroll);
            }

        } catch (SQLException e) {

            System.out.println("Error in getting all enrollments");


        }
        return Enrollments;
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(int studentId) {

        String query = "SELECT * FROM Enrollment WHERE StudentID=?";

        List<Enrollment> stEnroll = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Enrollment enroll = new Enrollment();

                enroll.setEnrollmentId(rs.getInt("EnrollmentId"));
                enroll.setStudentId(rs.getInt("StudentId"));
                enroll.setCourseId(rs.getInt("CourseID"));
                enroll.setInstructorId(rs.getInt("InstructorID"));


                stEnroll.add(enroll);
            }

        } catch (SQLException e) {

            System.out.println("Error in getting all enrollments");


        }
        return stEnroll;
    }

    @Override
    public void deleteEnrollment(int enrollId) {

        String query = "DELETE FROM Enrollment WHERE EnrollmentID=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, enrollId);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in deleting Enrollment" + e.getMessage());

        }


    }
}
