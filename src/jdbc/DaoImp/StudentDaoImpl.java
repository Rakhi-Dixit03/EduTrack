package jdbc.DaoImp;

import jdbc.Dao.StudentDao;
import jdbc.db.DBConnection;
import jdbc.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO Student(FirstName ,LastName, DateOfBirth ," +
                " Gender ,Email , Phone) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setDate(3, student.getDateOfBirth());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in adding Student :" + e.getMessage());

        }
        System.out.println("Student added Successfully");
    }

    @Override
    public List<Student> getAllStudents() {

        String query = "SELECT * FROM Student";
        List<Student> Students = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student st = new Student();

                st.setStId(rs.getInt("StudentID"));
                st.setFirstName(rs.getString("FirstName"));
                st.setLastName(rs.getString("LastName"));
                st.setDateOfBirth(rs.getDate("DateOfBirth"));
                st.setGender(rs.getString("Gender"));
                st.setEmail(rs.getString("Email"));
                st.setPhone(rs.getString("Phone"));
                Students.add(st);
            }

        } catch (SQLException e) {

            System.err.println("Error in getting all Students" + e.getMessage());
        }

        return Students;
    }

    @Override
    public Student getStudentByID(int id) {
        String query = "SELECT * FROM Student WHERE StudentID = ?";
        Student student = null;

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setStId(rs.getInt("StudentID"));
                student.setFirstName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setDateOfBirth(rs.getDate("DateOFBirth"));
                student.setGender(rs.getString("Gender"));
                student.setEmail(rs.getString("Email"));
                student.setPhone(rs.getString("Phone"));


            }
//            if(rs.getDate("DateOfBirth")!=null){
//
//                student.setDateOfBirth(Date.valueOf(rs.getDate("DateOfBirth").toLocalDate()));
//
//            }
        } catch (SQLException e) {

            System.err.println("Error in getting a StudentByID" + e.getMessage());

        }

        return student;
    }

    @Override
    public void updateStudent(Student student) {

        String query = "UPDATE Student SET FirstName=?, LastName = ?," +
                "DateOfBirth=?,Gender=?,Email=?,Phone=?" +
                " WHERE StudentId=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {


            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setDate(3, student.getDateOfBirth());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());
            ps.setInt(7, student.getStId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error in updating Student" + e.getMessage());

        }

        System.out.println("Student updated successfully !");
    }

    @Override
    public void deleteStudent(int id) {

        String query = "DELETE FROM Student WHERE StudentID=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in deleting Student" + e.getMessage());

        }
        System.out.println("Deleted student successfully!");

    }
}
