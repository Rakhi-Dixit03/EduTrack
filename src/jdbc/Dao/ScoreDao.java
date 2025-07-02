package jdbc.Dao;

import jdbc.model.Score;
import java.util.List;

public interface ScoreDao {


    void addScore(int studentId, int courseId, int credit, java.sql.Date dateOfExam);

    List<Score>getAllScores();
    List<Score>getScoresByStudent(int studentId);

     void updateScore(int scoreId, int studentId, int courseId, int credit, java.sql.Date dateOfExam);
}
