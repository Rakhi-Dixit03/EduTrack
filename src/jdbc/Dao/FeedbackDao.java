package jdbc.Dao;

import jdbc.model.Feedback;
import java.util.List;

public interface FeedbackDao {

    void addFeedback(int stId,String InstructorName,String feedback);
    List<Feedback>getAllFeedbacks();
    List<Feedback>getFeedbacksByStudent(int id);
    void deleteFeedback(int feedbackId);

}
