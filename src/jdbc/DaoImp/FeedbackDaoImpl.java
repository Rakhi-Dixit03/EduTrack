package jdbc.DaoImp;

import jdbc.Dao.FeedbackDao;
import jdbc.db.DBConnection;
import jdbc.model.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDaoImpl implements FeedbackDao {


    @Override
    public void addFeedback(int stId, String InstructorName, String feedback) {

        String query = "INSERT INTO Feedback(StudentId,InstructorName,Feedback) VALUES(?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);) {

//            ps.setInt(1,feedbackId);
            ps.setInt(1, stId);
            ps.setString(2, InstructorName);
            ps.setString(3, feedback);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in adding Feedback:" + e.getMessage());

        }

    }

    @Override
    public List<Feedback> getAllFeedbacks() {

        String query = "SELECT * FROM Feedback";
        List<Feedback> Feedbacks = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Feedback feedback = new Feedback();

                feedback.setFeedbackId(rs.getInt("FeedbackID"));
                feedback.setStudentId(rs.getInt("StudentId"));
                feedback.setInstructorName(rs.getString("InstructorName"));
                feedback.setFeedback(rs.getString("Feedback"));

                Feedbacks.add(feedback);
            }

        } catch (SQLException e) {
            System.out.println("Error in getting all Feedbacks");
        }
        return Feedbacks;

    }

    @Override
    public List<Feedback> getFeedbacksByStudent(int id) {

        String query = "SELECT * FROM Feedback WHERE StudentID=?";
        List<Feedback> Feedbacks = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Feedback feedback = new Feedback();

                feedback.setFeedbackId(rs.getInt("FeedbackID"));
                feedback.setStudentId(rs.getInt("StudentId"));
                feedback.setInstructorName(rs.getString("InstructorName"));
                feedback.setFeedback(rs.getString("Feedback"));

                Feedbacks.add(feedback);
            }

        } catch (SQLException e) {
            System.out.println("Error in getting feedbacks by ID");
        }
        return Feedbacks;
    }

    @Override
    public void deleteFeedback(int feedbackId) {

        String query = "DELETE FROM  Feedback WHERE  FeedbackID=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, feedbackId);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in deleting Feedback" + e.getMessage());

        }
        System.out.println("Deleted Feedback successfully!");

    }


}

