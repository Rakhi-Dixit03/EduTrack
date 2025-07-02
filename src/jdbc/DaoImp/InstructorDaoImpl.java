package jdbc.DaoImp;

import jdbc.Dao.InstructorDao;
import jdbc.db.DBConnection;
import jdbc.model.Instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDaoImpl implements InstructorDao {

    @Override
    public void addInstructor(Instructor instructor) {

        String query = "INSERT INTO Instructor(Email,FirstName,LastName) VALUES(?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setString(1, instructor.getEmail());
            ps.setString(2, instructor.getFirstName());
            ps.setString(3, instructor.getLastName());

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in adding instructor :" + e.getMessage());

        }
        System.out.println("instructor added Successfully");
    }


    @Override
    public List<Instructor> getAllInstructors() {

        String query = "SELECT * FROM Instructor";
        List<Instructor> Instructors = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Instructor inst = new Instructor(rs.getInt("InstructorID"),
                        rs.getString("Email"),
                        rs.getString("FirstName"),rs.getString("LastName"));

//                inst.setInstructorId(rs.getInt("InstructorID"));
//                inst.setEmail(rs.getString("Email"));
//                inst.setFirstName(rs.getString("FirstName"));
//                inst.setLastName(rs.getString("LastName"));

                Instructors.add(inst);
            }

        } catch (SQLException e) {

            System.out.println("Error in getting all instructors");


        }

        return Instructors;
    }

    @Override
    public Instructor getInstructorByID(int id) {

        String query = "SELECT * FROM Instructor WHERE InstructorID = ?";
        Instructor instructor = null;

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                instructor = new Instructor();
                instructor.setInstructorId(rs.getInt("InstructorID"));
                instructor.setEmail(rs.getString("Email"));
                instructor.setFirstName(rs.getString("FirstName"));
                instructor.setLastName(rs.getString("LastName"));


            }

        } catch (SQLException e) {

            System.err.println("Error in getting a InstructorByID" + e.getMessage());

        }
        return instructor;

    }

    @Override
    public void updateInstructor(Instructor instructor) {

        String query = "UPDATE Instructor SET Email=?,FirstName=?,LastName = ? WHERE InstructorID=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setString(1, instructor.getEmail());
            ps.setString(2, instructor.getFirstName());
            ps.setString(3, instructor.getLastName());
            ps.setInt(4, instructor.getInstructorId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error in updating  instructor" + e.getMessage());

        }
    }

    @Override
    public void deleteInstructor(int id) {
        String query = "DELETE FROM Instructor WHERE InstructorID=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in deleting Instructor" + e.getMessage());

        }
        System.out.println("Deleted Instructor successfully!");

    }
}


