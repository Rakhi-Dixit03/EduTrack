package jdbc.service;

import jdbc.model.Score;

import java.util.List;

public interface ScoreService {

    void addScore(int studentId, int courseId, int credit, java.sql.Date dateOfExam);

    List<Score> getAllScores();

    List<Score> findScoresByStudent(int studentId);

    void updateScore(int scoreId, int studentId, int courseId, int credit, java.sql.Date dateOfExam);


}
