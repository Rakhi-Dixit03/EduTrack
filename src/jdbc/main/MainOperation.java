package jdbc.main;


import java.util.Scanner;

public class MainOperation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AllOperations operation = new AllOperations();
        System.out.println("Welcome To Student Management System." +
                "You can Manage all operations at a single place.");


        while (true) {
            System.out.println("Press 1 for Student Operations : ");
            System.out.println("Press 2 for Course Operations : ");
            System.out.println("Press 3 for Instructor Operations : ");
            System.out.println("Press 4 for Enrollment operations: ");
            System.out.println("Press 5 for Score Operations : ");
            System.out.println("Press 6 for Feedback Operations : ");
            System.out.println("Press 0 to Exit.");

            System.out.println("Enter your choice :");
          int userInput = sc.nextInt();
            sc.nextLine();

            switch (userInput) {

                case 1:
                    operation.studentMenu();
                    break;
                case 2:
                    operation.courseMenu();
                    break;
                case 3:
                    operation.instructorMenu();
                    break;
                case 4:
                    operation.enrollmentMenu();
                    break;
                case 5:
                    operation.scoreMenu();
                    break;
                case 6:
                    operation.feedbackMenu();
                    break;
                case 0:
                    System.out.println("Exiting....");
                    return;

                default:
                    System.out.println("Invalid choice!" +
                            " Please choose the right option.");
            }


        }


    }
}