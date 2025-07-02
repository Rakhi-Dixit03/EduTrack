package jdbc.serviceImpl;

import jdbc.Dao.ScoreDao;
import jdbc.DaoImp.ScoreDaoImpl;
import jdbc.model.Score;
import jdbc.service.ScoreService;

import java.sql.Date;
import java.util.List;

public class ScoreServiceImpl implements ScoreService {

    private final ScoreDao scoreDao;

    public ScoreServiceImpl() {
        this.scoreDao = new ScoreDaoImpl();


    }

    @Override
    public void addScore(int studentId, int courseId, int credit, Date dateOfExam) {
        scoreDao.addScore(studentId, courseId, credit, dateOfExam);
    }

    @Override
    public List<Score> getAllScores() {
        return scoreDao.getAllScores();
    }

    @Override
    public List<Score> findScoresByStudent(int studentId) {
        return scoreDao.getScoresByStudent(studentId);
    }

    @Override
    public void updateScore(int scoreId, int studentId, int courseId, int credit, Date dateOfExam) {
        scoreDao.updateScore(scoreId, studentId, courseId, credit, dateOfExam);
    }
}
