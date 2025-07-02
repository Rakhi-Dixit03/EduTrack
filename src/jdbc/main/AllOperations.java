package jdbc.main;

import jdbc.model.*;
import jdbc.service.*;
import jdbc.serviceImpl.*;

import jdbc.model.*;
import jdbc.service.*;
import jdbc.serviceImpl.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class AllOperations {

    public void studentMenu() {
        StudentService studentService = new StudentServiceImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("**** Student Menu **** ");
            System.out.println("Press 1 to add new Student ");
            System.out.println("Press 2 to view all Students ");
            System.out.println("Press 3 to search a Student by ID");
            System.out.println("Press 4  to update  Student data ");
            System.out.println("Press 5 to delete  Student ");
            System.out.println("Press 0 to Exit ");
            System.out.println("Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1: {

//                    System.out.println("Enter ID of Student : ");
//                    int id=sc.nextInt();
                    System.out.println("Enter FirstName: ");
                    String firstname = sc.nextLine();
                    System.out.println("Enter LastName: ");
                    String lastname = sc.nextLine();

                    System.out.println("Enter Date of Birth (dd/MM/yyyy): ");
                    String dobStr = sc.nextLine();

                    LocalDate dob = null;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    try {
                        dob = LocalDate.parse(dobStr, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println(" Invalid date format. Please use dd/MM/yyyy");
                        return;
                    }

                    System.out.println("Enter Gender : ");
                    String gender = sc.nextLine();
                    System.out.println("Enter Email : ");
                    String email = sc.nextLine();
                    System.out.println("Enter Phone Number: ");
                    String phone = sc.nextLine();
                    studentService.registerStudent(new Student(firstname, lastname, dob, gender, email, phone));
                    System.out.println("Student added.");
                    break;
                }

                case 2: {
                    if (studentService.getAllStudents().isEmpty()) {
                        System.out.println("There is no Studentin the student list.First you need to add one. ");
                    } else {

                        studentService.getAllStudents().forEach(s ->
                                System.out.println("ID : " + s.getStId() + ", Name : " +
                                        s.getFirstName() + " " + s.getLastName() + ", " +
                                        "Date of Birth : " + s.getDateOfBirth() + ", gender : "
                                        + s.getGender() + ", Email : " + s.getEmail()));
                    }
                    break;
                }

                case 3: {
                    System.out.println("Enter student ID : ");
                    int id = sc.nextInt();

                    Student s = studentService.findStudentById(id);
                    if (s != null) {
                        System.out.println("( Student  Found -> Name : " + s.getFirstName() + " " + s.getLastName() +
                                "," + "email : " + s.getEmail());
                    } else {
                        System.out.println("Student not found!");

                    }
                    break;
                }

                case 4: {


                    System.out.println("Enter ID of Student : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Student s = studentService.findStudentById(id);
                    if (s != null) {
                        System.out.println("Enter FirstName: ");
                        String firstname = sc.nextLine();
                        System.out.println("Enter LastName: ");
                        String lastname = sc.nextLine();
                        System.out.println("Enter Date of Birth in (dd/MM/yyyy) format : ");
                        String dobStr = sc.nextLine();

                        LocalDate dob = null;
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        try {
                            dob = LocalDate.parse(dobStr, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println(" Invalid date format. Please use dd/MM/yyyy");
                            return;
                        }

                        System.out.println("Enter Gender : ");
                        String gender = sc.nextLine();
                        System.out.println("Enter Email : ");
                        String email = sc.nextLine();
                        System.out.println("Enter Phone Number: ");
                        String phone = sc.nextLine();
                        studentService.updateStudent(new Student(id, firstname, lastname, dob, gender, email, phone));
                        System.out.println("Student Updated !");

                    } else {
                        System.out.println("Can't Update data which doesn't exist.");

                    }
                    break;
                }

                case 5: {
                    System.out.println("Enter student ID : ");
                    int id = sc.nextInt();
                    Student s = studentService.findStudentById(id);
                    if (s != null) {
                        studentService.removeStudent(id);
                        System.out.println("Student removed successfully !");
                    } else {
                        System.out.println("This Student can't be removed which doesn't exist.");
                    }
                    break;
                }

                case 0: {
                    System.out.println("Exiting.....");
                    return;
                }
                default:
                    System.out.println("Invalid choice !");
            }


        }
    }

    public void courseMenu() {

        CourseService courseService = new CourseServiceImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("**** Course Menu **** ");
            System.out.println("Press 1 to add a new Course ");
            System.out.println("Press 2 to view all Courses ");
            System.out.println("Press 3 to search a Course by ID");
            System.out.println("Press 4  to update  Course data ");
            System.out.println("Press 5 to delete  a Course");
            System.out.println("Press 0 to Exit ");

            System.out.println("Now Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1: {

                    System.out.println("Enter Course ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Course Title : ");
                    String title = sc.nextLine();
                    System.out.println("Enter Credits of course : ");
                    int credits = sc.nextInt();

                    courseService.addCourse(new Course(id, title, credits));
                    System.out.println("Course added.");
                    break;
                }

                case 2: {
                    if (courseService.getAllCourses().isEmpty()) {
                        System.out.println("No Course Found in the List of Course.You must first insert.");
                    } else {
                        courseService.getAllCourses().forEach(c ->
                                System.out.println("CourseID : " + c.getCourseId() + ", Course Title : " +

                                        c.getCourseTitle() + ", Course Credits :  " + c.getCredits()));
                    }
                    break;
                }

                case 3: {
                    System.out.println("Enter course  ID : ");
                    int id = sc.nextInt();

                    Course c = courseService.findCourseById(id);
                    if (c != null) {
                        System.out.println("Course  Found  : courseId : " + c.getCourseId() + ", Title :" + c.getCourseTitle() +
                                ", Credits  : " + c.getCredits());
                    } else {
                        System.out.println("Course not found!");

                    }
                    break;
                }

                case 4: {


                    System.out.println("Enter ID of Course: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Course c = courseService.findCourseById(id);
                    if (c != null) {
                        System.out.println("Enter Course Title : ");
                        String title = sc.nextLine();
                        System.out.println("Enter credits : ");
                        int credits = sc.nextInt();

                        courseService.updateCourse(new Course(id, title, credits));
                        System.out.println("Course Updated.");
                    } else {
                        System.out.println("Course can't be Updated.");
                    }
                    break;

                }

                case 5: {
                    System.out.println("Enter course ID : ");
                    int id = sc.nextInt();
                    Course c = courseService.findCourseById(id);
                    if (c != null) {
                        courseService.removeCourse(id);
                        System.out.println("Course  removed successfully !");
                    } else {
                        System.out.println("Course can't be removed which doesn't exist.");
                    }
                    break;
                }

                case 0: {
                    System.out.println("Exiting.....");
                    return;
                }
                default:
                    System.out.println("Invalid choice !");
            }


        }
    }


    public void instructorMenu() {
        InstructorService instructorService = new InstructorServiceImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("**** Instructor Menu **** ");
            System.out.println("Press 1 to add new Instructor ");
            System.out.println("Press 2 to view all Instructor");
            System.out.println("Press 3 to search an Instructor by ID");
            System.out.println("Press 4  to update  an Instructor's  data ");
            System.out.println("Press 5 to delete Instructor ");
            System.out.println("Press 0 to Exit ");
            System.out.println("Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1: {

//                System.out.println("Enter Instructor ID :");
//                int id=sc.nextInt();
                    System.out.println("Enter Email : ");
                    String email = sc.nextLine();
                    System.out.println("Enter FirstName: ");
                    String firstname = sc.nextLine();
                    System.out.println("Enter LastName: ");
                    String lastname = sc.nextLine();

                    instructorService.addInstructor(new Instructor(email, firstname, lastname));
                    System.out.println("Instructor added.");
                    break;
                }

                case 2: {
                    if (instructorService.getAllInstructors().isEmpty()) {

                        System.out.println("No instructor found in the Instructor List.");
                    } else {
                        instructorService.getAllInstructors().forEach(i ->
                                System.out.println("ID : " + i.getInstructorId() + " , Email : " + i.getEmail() +
                                        ", Name : " + i.getFirstName() + " " + i.getLastName()));
                    }
                    break;
                }

                case 3: {
                    System.out.println("Enter Instructor ID : ");
                    int id = sc.nextInt();

                    Instructor i = instructorService.findInstructorById(id);
                    if (i != null) {
                        System.out.println("Instructor Found : Name : " + i.getFirstName() + " " + i.getLastName() +
                                ", email : " + i.getEmail());
                    } else {
                        System.out.println("Instructor not found!");

                    }
                    break;
                }

                case 4: {

                    System.out.println("Enter ID of Instructor : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Instructor i = instructorService.findInstructorById(id);
                    if (i != null) {

                        System.out.println("Enter FirstName: ");

                        String firstname = sc.nextLine();
                        System.out.println("Enter LastName: ");
                        String lastname = sc.nextLine();

                        System.out.println("Enter Email : ");
                        String email = sc.nextLine();

                        instructorService.updateInstructor(new Instructor(id, firstname, lastname, email));
                        System.out.println("Instructor Updated !");
                    } else {
                        System.out.println("You can't update Instructor which can't exist.");
                    }
                    break;

                }

                case 5: {
                    System.out.println("Enter Instructor ID : ");
                    int id = sc.nextInt();
                    Instructor i = instructorService.findInstructorById(id);
                    if (i != null) {
                        instructorService.removeInstructor(id);
                        System.out.println("Instructor removed successfully !");

                    } else {
                        System.out.println("Can't Remove Instructor !");
                    }
                    break;
                }

                case 0: {
                    System.out.println("Exiting.....");
                    return;
                }
                default:
                    System.out.println("Invalid choice !");
            }


        }
    }

    public void enrollmentMenu() {
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("**** Enrollment Menu **** ");
            System.out.println("Press 1 to make new enrollment ");
            System.out.println("Press 2 to view all enrollments");
            System.out.println("Press 3 to search an enrollments by ID");
            System.out.println("Press 4 to delete an enrollment ");
            System.out.println("Press 0 to Exit ");
            System.out.println("Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1: {

//                System.out.println("Enter Instructor ID :");
//                int id=sc.nextInt();
                    System.out.println("Enter studentID : ");
                    int stID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter CourseID : ");
                    int CourseID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter InstructorID : ");
                    int InstructorID = sc.nextInt();
                    enrollmentService.makeEnrollment(stID, CourseID, InstructorID);
                    System.out.println("Your Enrollment is done successfully!");
                    break;
                }

                case 2: {

                    if (enrollmentService.getAllEnrollments().isEmpty()) {
                        System.out.println("No enrollment yet! Make one.");
                    } else {
                        enrollmentService.getAllEnrollments().forEach(e ->
                                System.out.println("EnrollmentID : " + e.getEnrollmentId() + ", StudentID : " + e.getStudentId() +
                                        ", CourseID " + e.getCourseId() + ", InstructorID " + e.getInstructorId()));
                    }
                    break;
                }

                case 3: {
                    System.out.println("Enter Student ID : ");
                    int id = sc.nextInt();

                    if (enrollmentService.findEnrollmentsByStudent(id).isEmpty()) {
                        System.out.println("No  enrollment data found !");
                    } else {
                        List<Enrollment> list = enrollmentService.findEnrollmentsByStudent(id);

                        for (Enrollment e : list)
                            System.out.println(e.toString());
                    }
                    break;
                }

                case 4: {

                    System.out.println("Enter Enrollment ID :");
                    int id = sc.nextInt();

                    enrollmentService.removeEnrollment(id);
                    System.out.println("Enrollment removed successfully !");
                    break;
                }

                case 0: {
                    System.out.println("Exiting.....");
                    return;
                }
                default:
                    System.out.println("Invalid choice !");
            }


        }


    }

    public void scoreMenu() {

        ScoreService scoreService = new ScoreServiceImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("**** Score Menu **** ");
            System.out.println("Press 1 to  add Score");
            System.out.println("Press 2 to view all Scores");
            System.out.println("Press 3 to search scores by ID");
            System.out.println("Press 4 to update a score ");
            System.out.println("Press 0 to Exit ");
            System.out.println("Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1: {

//                System.out.println("Enter Instructor ID :");
//                int id=sc.nextInt();
                    System.out.println("Enter studentID : ");
                    int stID = sc.nextInt();
                    System.out.println("Enter CourseID : ");
                    int CourseID = sc.nextInt();
                    System.out.println("Enter creditObtained: ");
                    int credits = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Date of Exam in (dd/MM/yyyy) format : ");
                    String dateStr = sc.nextLine();
                    LocalDate date = null;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    try {
                        date = LocalDate.parse(dateStr, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println(" Invalid date format. Please use dd/MM/yyyy");
                        return;
                    }
                    scoreService.addScore(stID, CourseID, credits, Date.valueOf(date));
                    System.out.println("Score Saved");
                    break;
                }

                case 2: {
                    if (scoreService.getAllScores().isEmpty()) {
                        System.out.println("Doesn't have any Score data yet.Store one.");
                    } else {
                        scoreService.getAllScores().forEach(s ->
                                System.out.println("ScoreID : " + s.getScoreId() + ", StudentID : " + s.getStudentId() +
                                        ", CourseID " + s.getCourseId() + ", CreditsObtained :" + s.getCreditObtained() +
                                        ", Date of Exam : " + s.getDateOfExam()));
                    }

                    break;
                }

                case 3: {
                    System.out.println("Enter Student ID : ");
                    int id = sc.nextInt();

                    if (scoreService.findScoresByStudent(id).isEmpty()) {
                        System.out.println("No Score data found related to this student.");
                    } else {
                        List<Score> list = scoreService.findScoresByStudent(id);

                        for (Score e : list)
                            System.out.println(e.toString());
                    }
                    break;
                }

                case 4: {

                    System.out.println("Enter studentID : ");
                    int stID = sc.nextInt();

                    if (scoreService.findScoresByStudent(stID).isEmpty()) {
                        System.out.println("Can't update.");
                    } else {

                        System.out.println("Enter ScoreID : ");
                        int scoreID = sc.nextInt();

                        System.out.println("Enter CourseID : ");
                        int CourseID = sc.nextInt();
                        System.out.println("Enter creditObtained: ");
                        int credits = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Date of Exam in (dd/MM/yyyy) format : ");
                        String dateStr = sc.nextLine();
                        LocalDate date = null;
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        try {
                            date = LocalDate.parse(dateStr, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println(" Invalid date format. Please use dd/MM/yyyy");
                            return;
                        }
                        scoreService.updateScore(scoreID, stID, CourseID, credits, Date.valueOf(date));
                        System.out.println("Score updated");

                    }
                    break;

                }

                case 0: {
                    System.out.println("Exiting.....");
                    return;
                }
                default:
                    System.out.println("Invalid choice !");
            }

        }
    }

    public void feedbackMenu() {

        FeedbackService feedbackService = new FeedbackServiceImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("**** Feedback Menu **** ");
            System.out.println("Press 1 to add new Feedback ");
            System.out.println("Press 2 to view all Feedbacks");
            System.out.println("Press 3 to search Feedbacks by ID");
            System.out.println("Press 4 to delete a Feedback ");
            System.out.println("Press 0 to Exit ");
            System.out.println("Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1: {

                    System.out.println("Enter Student ID :");
                    int stId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Instructor Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Feedback: ");
                    String feedback = sc.nextLine();


                    feedbackService.addFeedback(stId, name, feedback);
                    System.out.println("Feedback added.");
                    break;
                }

                case 2: {
                    if (feedbackService.getAllFeedbacks().isEmpty()) {
                        System.out.println("Can't find any feedback! Add one.");
                    } else {
                        feedbackService.getAllFeedbacks().forEach(f ->
                                System.out.println("feedbackID : " + f.getFeedbackId() + ", StudentId : " + f.getStudentId() +
                                        ", Name of instructor : " + f.getInstructorName() + ", Feedback :" +
                                        f.getFeedback()));
                    }
                    break;
                }

                case 3: {

                    System.out.println("Enter Student ID : ");
                    int id = sc.nextInt();

                    if (feedbackService.findFeedbacksByStudent(id).isEmpty()) {
                        System.out.println("Don't have feedback data related to this student.");
                    } else {
                        List<Feedback> list = feedbackService.findFeedbacksByStudent(id);

                        for (Feedback f : list)
                            System.out.println(f.toString());
                    }
                    break;
                }
                case 4: {

                    System.out.println("Enter FeedbackId : ");
                    int feedID = sc.nextInt();

                    feedbackService.removeFeedback(feedID);
                    System.out.println("Feedback deleted successfully!");

                    break;

                }

                case 0: {
                    System.out.println("Exiting.....");
                    return;
                }
                default:
                    System.out.println("Invalid choice !");


            }

        }


    }
}