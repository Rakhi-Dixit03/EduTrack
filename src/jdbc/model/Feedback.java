package jdbc.model;

public class Feedback {

    private int feedbackId;
    private int studentId;
    private String instructorName;
    private String feedback;

    public Feedback(int studentId, String instructorName, String feedback) {
        this.studentId = studentId;
        this.instructorName = instructorName;
        this.feedback = feedback;
    }

    public Feedback() {
    }

    public Feedback(int feedbackId, int studentId, String instructorName, String feedback) {
        this.feedbackId = feedbackId;
        this.studentId = studentId;
        this.instructorName = instructorName;
        this.feedback = feedback;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", studentId=" + studentId +
                ", instructorName='" + instructorName + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
