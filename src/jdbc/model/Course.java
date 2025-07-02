package jdbc.model;

public class Course {

    private int courseId;
    private String courseTitle;
    private int Credits;


  public Course(){}


    public Course(int courseId, String courseTitle, int credits) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        Credits = credits;
    }



    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", Credits=" + Credits +
                '}';
    }

}
