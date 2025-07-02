package jdbc.serviceImpl;

import jdbc.Dao.FeedbackDao;
import jdbc.DaoImp.FeedbackDaoImpl;
import jdbc.model.Feedback;
import jdbc.service.FeedbackService;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDao feedbackDao;

    public FeedbackServiceImpl() {
        this.feedbackDao = new FeedbackDaoImpl();
    }

    @Override
    public void addFeedback(int stId, String InstructorName, String feedback) {
        feedbackDao.addFeedback(stId, InstructorName, feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    @Override
    public List<Feedback> findFeedbacksByStudent(int id) {
        return feedbackDao.getFeedbacksByStudent(id);
    }

    @Override
    public void removeFeedback(int feedbackId) {
        feedbackDao.deleteFeedback(feedbackId);
    }

}

