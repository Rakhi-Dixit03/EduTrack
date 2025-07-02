package jdbc.DaoImp;

import jdbc.Dao.ScoreDao;
import jdbc.db.DBConnection;
import jdbc.model.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDaoImpl implements ScoreDao {

    @Override
    public void addScore(int studentId, int courseId, int credit, java.sql.Date dateOfExam) {

        String query = "INSERT INTO Score(StudentId,CourseID,CreditObtained,DateOFExam) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setInt(3, credit);
            ps.setDate(4, dateOfExam);

            ps.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error in adding Score:" + e.getMessage());

        }
    }

    @Override
    public List<Score> getAllScores() {

        String query = "SELECT * FROM Score";
        List<Score> Scores = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Score score = new Score();

                score.setScoreId(rs.getInt("ScoreID"));
                score.setStudentId(rs.getInt("StudentId"));
                score.setCourseId(rs.getInt("CourseId"));
                score.setCreditObtained(rs.getInt("CreditObtained"));
                score.setDateOfExam(rs.getDate("DateOFExam"));

                Scores.add(score);
            }

        } catch (SQLException e) {
            System.out.println("Error in getting all Scores");
        }
        return Scores;
    }

    @Override
    public List<Score> getScoresByStudent(int studentId) {

        String query = "SELECT * FROM Score WHERE StudentId=?";
        List<Score> Scores = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Score score = new Score();

                score.setScoreId(rs.getInt("ScoreID"));
                score.setStudentId(rs.getInt("StudentId"));
                score.setCourseId(rs.getInt("CourseId"));
                score.setCreditObtained(rs.getInt("CreditObtained"));
                score.setDateOfExam(rs.getDate("DateOFExam"));

                Scores.add(score);
            }

        } catch (SQLException e) {
            System.out.println("Error in getting Scores By student Id.");
        }

        return Scores;
    }

    @Override
    public void updateScore(int scoreId, int studentId, int courseId, int credit, java.sql.Date dateOfExam) {
        String query = "UPDATE Score SET ScoreID=?,CourseID = ?,CreditObtained=?,DateOfExam=? WHERE StudentID=?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(query);) {

            ps.setInt(1, scoreId);
            ps.setInt(2, courseId);
            ps.setInt(3, credit);
            ps.setDate(4, dateOfExam);
            ps.setInt(5, studentId);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error in updating  Score" + e.getMessage());

        }
    }


}
