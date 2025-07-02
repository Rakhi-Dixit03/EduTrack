package jdbc.model;

public class Enrollment {

    private int enrollmentId;
    private int studentId;
    private int CourseId;
    private int instructorId;

    public Enrollment(){}

    //For  data Insertion
    public Enrollment(int studentId, int courseId, int instructorId) {
        this.studentId = studentId;
        this.CourseId = courseId;
        this.instructorId = instructorId;
    }

    //For getting data
    public Enrollment(int enrollmentId, int studentId, int courseId, int instructorId) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.CourseId = courseId;
        this.instructorId = instructorId;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }


    @Override
    public String toString() {
        return "Enrollment { " +
                "enrollmentId=" + enrollmentId +
                ", studentId=" + studentId +
                ", CourseId=" + CourseId +
                ", instructorId=" + instructorId +" "+
                '}';
    }
}
