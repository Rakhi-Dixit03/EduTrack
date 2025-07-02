package jdbc.service;

import jdbc.model.Feedback;

import java.util.List;

public interface FeedbackService {

    void addFeedback(int stId, String InstructorName, String feedback);

    List<Feedback> getAllFeedbacks();

    List<Feedback> findFeedbacksByStudent(int id);

    void removeFeedback(int feedbackId);


}
