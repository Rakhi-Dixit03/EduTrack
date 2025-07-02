package jdbc.model;

import java.sql.Date;

public class Score {


        private int scoreId;
        private int studentId;
        private int courseId;
        private int creditObtained;
        private Date dateOfExam;


        public Score(){}
    //for inserting
    public Score(int studentId, int courseId, int creditObtained, Date dateOfExam) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.creditObtained = creditObtained;
        this.dateOfExam = dateOfExam;
    }

    //for getting
    public Score(int scoreId, int studentId, int courseId, int creditObtained, Date dateOfExam) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.creditObtained = creditObtained;
        this.dateOfExam = dateOfExam;
    }

    public int getScoreId() {
            return scoreId;
        }

        public void setScoreId(int scoreId) {
            this.scoreId = scoreId;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public Date getDateOfExam() {
            return dateOfExam;
        }


        public void setDateOfExam(Date dateOfExam) {
            this.dateOfExam = dateOfExam;
        }


        public int getCreditObtained() {
        return creditObtained;
    }

        public void setCreditObtained(int creditObtained) {
            this.creditObtained = creditObtained;
        }


        @Override
        public String toString() {
            return "Score{ " +
                    "scoreId = " + scoreId +
                    ", studentId = " + studentId +
                    ", courseId=" + courseId +
                    ", creditObtained = " + creditObtained +
                    ", dateOfExam = " + dateOfExam +" "+
                    '}';
        }
}
